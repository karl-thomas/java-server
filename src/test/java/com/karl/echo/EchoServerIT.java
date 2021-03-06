package com.karl.echo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import com.karl.Client;
import com.karl.constants.Globals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class EchoServerIT {
  @Nested
  @TestInstance(Lifecycle.PER_CLASS)
  @DisplayName("when the server is running")
  class when_server_is_started {
    private Client client;

    @BeforeEach
    public void setup() throws IOException {
      client = new Client();
      client.connectTo(Globals.HOST, Globals.PORT);
    }

    @AfterEach
    public void tearDown() throws IOException {
      client.close();
    }

    @Test
    @DisplayName("server echoes back clients message")
    public void echoClientMessage() throws IOException {
      String msg = "howdy";
      String resp = client.sendMessage(msg);
      assertEquals(msg, resp.trim());
    }

    @Test
    @DisplayName("server echoes back multiple message from the same client")
    public void echoMultipleMessageFromSameClient() throws IOException {
      String msg = "well hello";
      String msg2 = "there";
      String resp = client.sendMessage(msg);
      String resp2 = client.sendMessage(msg2);
      assertEquals(msg, resp.trim());
      assertEquals(msg2, resp2.trim());
    }

    @Test
    @DisplayName("server can respond to multiple messages, one client at a time")
    public void echoAlternatingClients() throws IOException {
      String msg1 = "Howdy";
      String resp1 = client.sendMessage(msg1);
      client.close();

      client = new Client();
      client.connectTo(Globals.HOST, Globals.PORT);
      String msg2 = "Pard'ner";
      String resp2 = client.sendMessage(msg2);

      assertEquals(msg1, resp1.trim());
      assertEquals(msg2, resp2.trim());
    }

    @Test
    @DisplayName("server can handle multiple requests at the same time")
    public void echoSimultaneousRequests() throws IOException {
      String msg1 = "Howdy";
      String resp1 = client.sendMessage(msg1);
      Client client2 = new Client();
      client2.connectTo(Globals.HOST, Globals.PORT);
      String msg2 = "Pard'ner";
      String resp2 = client2.sendMessage(msg2);
      client2.close();
      assertEquals(msg1, resp1.trim());
      assertEquals(msg2, resp2.trim());
    }

  }
}

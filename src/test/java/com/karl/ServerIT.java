package com.karl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import com.karl.constants.Globals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ServerIT {
  @Nested
  @TestInstance(Lifecycle.PER_CLASS)
  @DisplayName("when the server is running")
  class when_server_is_started {
    private Client client;

    @BeforeAll
    public void setup() throws IOException {
      client = new Client();
      client.connectTo(Globals.HOST, Globals.PORT);
    }

    @AfterAll
    public void tearDown() throws IOException {
      client.close();
    }

    @Test
    @DisplayName("server echoes back clients message")
    public void echoClientMessage() throws IOException {
      String msg = "howdy";
      String resp = client.sendMessage(msg);
      assertEquals(msg, resp);
    }

    @Test
    @DisplayName("server echoes back multiple message from the same client")
    public void echoMultipleMessageFromSameClient() throws IOException {
      String msg = "well hello";
      String msg2 = "there";
      String resp = client.sendMessage(msg);
      String resp2 = client.sendMessage(msg2);
      assertEquals(msg, resp);
      assertEquals(msg2, resp2);
    }
  }
}

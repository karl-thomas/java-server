package com.karl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ServerTest {

  @Nested
  @TestInstance(Lifecycle.PER_CLASS)
  @DisplayName("when the server is running")
  class when_server_is_started {
    private Client client;

    @BeforeAll
    public void setup() throws IOException {
      client = new Client();
      client.connectTo("127.0.0.1", 6666);
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
  }
}

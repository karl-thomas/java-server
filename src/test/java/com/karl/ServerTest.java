package com.karl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;

public class ServerTest {

  @Nested
  @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
  class when_server_is_started {
    private Client client;

    @BeforeEach
    void setup() throws IOException {
      client = new Client();
      client.connectTo("127.0.0.1", 6666);
    }

    @AfterEach
    void tearDown() throws IOException {
      client.close();
    }

    @Test
    public void givenClient_whenServerRespondsWhenStarted_thenCanConn() throws IOException {
      String response = client.sendMessage("hey");
      assertEquals("HOWDY PARDNER", response);
    }

  }

}

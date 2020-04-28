package com.karl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.net.Socket;
import com.karl.constants.Globals;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ClientConnectionTest {
  @Nested
  class closeMethod {
    @Test
    public void shouldCloseInnerSocket() throws IOException {
      Socket innerSocket = new Socket("google.com", 80);
      ClientConnection socket = new ClientConnection(innerSocket);
      socket.close();

      assertTrue(innerSocket.isClosed());
    }

    @Test
    public void readUntilShouldGiveYouAllTheTextBeforeAndIncludingALimiter() throws IOException {
      String content = "oh buddy its a string with a clrf" + Globals.CRLF;
      String extra = "not this stuff oh nooooooo!!!";
      String searchString = content + extra;
      Socket innerSocket = new Socket("google.com", 80);
      ClientConnection socket = new ClientConnection(innerSocket);
    }
  }
}

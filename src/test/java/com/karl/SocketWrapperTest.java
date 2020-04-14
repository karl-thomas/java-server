package com.karl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.net.Socket;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SocketWrapperTest {
  @Nested
  class closeMethod {
    @Test
    public void shouldCloseInnerSocket() throws IOException {
      Socket innerSocket = new Socket("google.com", 80);
      SocketWrapper socket = new SocketWrapper(innerSocket);
      socket.close();

      assertTrue(innerSocket.isClosed());
    }
  }
}

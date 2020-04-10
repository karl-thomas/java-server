package com.karl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServerSocketWrapperTest {
  @Test
  @DisplayName("close should close the inner server socket")
  public void close_shouldCloseInnerSocket() throws IOException {
    ServerSocketWrapper socket = new ServerSocketWrapper(8080);
    socket.close();
    assertTrue(socket.isClosed());
  }
}

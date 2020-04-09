package com.karl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ServerSocketWrapperTest {
  @Nested
  class closeMethod {
    @Test
    public void shouldCloseInnerSocket() throws IOException {
      ServerSocketWrapper socket = new ServerSocketWrapper(8080);
      socket.close();
      assertTrue(socket.isClosed());
    }
  }
}

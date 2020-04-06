package com.karl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import com.karl.mocks.MockSocket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServerTest {
  @Test
  @DisplayName("server can read from a socket")
  public void serverCanHandleARequest() throws IOException {
    Server server = new Server(Globals.PORT);
    MockSocket mockSocket = new MockSocket();
    String message = "IM A MOOOOCCCKKKKKKKKKKK";
    mockSocket.setStreamText(message);
    String requestCustom = server.createRequestFrom(mockSocket).readLine();
    assertEquals(message, requestCustom);
  }
}

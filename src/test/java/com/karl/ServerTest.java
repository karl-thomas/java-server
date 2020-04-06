package com.karl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import com.karl.mocks.MockServerSocket;
import com.karl.mocks.MockSocket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServerTest {
  private String defaultStreamText = "default message from client";

  private MockSocket createMockSocket(String streamText) {
    MockSocket mockSocket = new MockSocket();
    mockSocket.streamText = streamText;
    return mockSocket;
  }

  @Test
  @DisplayName("server can connect to a client socket")
  public void serverCanConnectToSocket() throws IOException {
    MockSocket socket = createMockSocket(defaultStreamText);
    MockServerSocket serverSocket = new MockServerSocket();
    serverSocket.socket = socket;

    Server server = new Server(serverSocket);

    assertEquals(server.accept(), socket);
    server.close();
  }

  @Test
  @DisplayName("server can read from a socket")
  public void serverCanHandleARequest() throws IOException {
    Server server = new Server(new MockServerSocket());
    String message = "hello!";
    MockSocket socket = createMockSocket(message);

    String requestCustom = server.createRequestFrom(socket).readLine();
    assertEquals(message, requestCustom);
    server.close();
  }

  @Test
  @DisplayName("server can write to a socket")
  public void serverCanSendResponse() throws IOException {
    Server server = new Server(new MockServerSocket());
    MockSocket mockSocket = new MockSocket();
    server.writeTo(mockSocket, "hey there");
    assertEquals("hey there\n", mockSocket.sentToClient());
  }
}

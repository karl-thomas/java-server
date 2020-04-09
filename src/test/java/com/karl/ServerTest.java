package com.karl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import com.karl.mocks.MockServerSocket;
import com.karl.mocks.MockSocketWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
public class ServerTest {
  @Test
  @DisplayName("server can connect to a client socket")
  public void serverCanConnectToSocket() throws IOException {
    MockSocketWrapper socket = new MockSocketWrapper();
    MockServerSocket serverSocket = new MockServerSocket();
    serverSocket.socket = socket;

    Server server = new Server(serverSocket);

    assertEquals(server.accept(), socket);
    server.close();
  }

  @Test
  @DisplayName("server writes the same message, with a newline, to the client it was sent from")
  public void serverCanHandleARequest() throws IOException {
    String message = "hello there!";
    MockSocketWrapper mocket = new MockSocketWrapper(message);
    MockServerSocket serverSocket = new MockServerSocket();
    serverSocket.socket = mocket;
    Server server = new Server(serverSocket);

    serverSocket.closeAfterConnections(1);
    server.start();

    String result = mocket.sentToClient();

    assertEquals(message + "\n", result);
    server.close();
  }
}

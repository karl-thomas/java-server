package com.karl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import com.karl.mocks.MockServerSocket;
import com.karl.mocks.MockSocketWrapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("unit")
public class ServerTest {
  private MockSocketWrapper mocket;
  private MockServerSocket serverSocket;
  private Server server;

  @BeforeEach
  public void setupEach() throws IOException {
    mocket = new MockSocketWrapper();
    serverSocket = new MockServerSocket();
    serverSocket.socket = mocket;
    server = new Server(serverSocket);
  }

  @AfterEach
  public void tearDownEach() throws IOException {
    server.close();
  }

  @Test
  @DisplayName("server can connect to a client socket")
  public void serverCanConnectToSocket() throws IOException {
    assertEquals(server.accept(), mocket);
  }

  @Test
  @DisplayName("server will not write anything if the client didn't send anthing")
  public void serverWillNotRespondToNothing() throws IOException {
    String message = "";
    mocket.textFromClient = message;

    serverSocket.closeAfterConnections(1);
    server.start();

    String result = mocket.sentToClient();

    assertEquals(message, result);
  }

  @Test
  @DisplayName("server writes the same message, with a newline, to the client it was sent from")
  public void serverCanHandleARequest() throws IOException {
    String message = "hello there!";
    mocket.textFromClient = message;

    serverSocket.closeAfterConnections(1);
    server.start();

    String result = mocket.sentToClient();

    assertEquals(message + "\n", result);
  }
}

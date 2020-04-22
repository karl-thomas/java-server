package com.karl.echo;

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
public class EchoServerTest {
  private MockSocketWrapper mocket;
  private MockServerSocket serverSocket;
  private EchoServer server;

  @BeforeEach
  public void setupEach() throws IOException {
    mocket = new MockSocketWrapper();
    serverSocket = new MockServerSocket();
    serverSocket.socket = mocket;
    server = new EchoServer(serverSocket);
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
}

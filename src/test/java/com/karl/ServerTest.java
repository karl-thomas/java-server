package com.karl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import com.karl.mocks.MockProtocolFactory;
import com.karl.mocks.MockRunnable;
import com.karl.mocks.MockServerSocket;
import com.karl.mocks.MockSocketWrapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ServerTest {
  private MockSocketWrapper mocket;
  private MockServerSocket serverSocket;
  private MockRunnable threadedProcedure;
  private MockProtocolFactory protocolFactory;
  private Server server;

  @BeforeEach
  public void setupEach() throws IOException {
    mocket = new MockSocketWrapper();
    serverSocket = new MockServerSocket();
    threadedProcedure = new MockRunnable();
    protocolFactory = new MockProtocolFactory().setRunner(threadedProcedure);
    serverSocket.socket = mocket;
    server = new Server(serverSocket, protocolFactory);
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
  @DisplayName("server will create a new protocol handler on connect")
  public void serverCreatesNewHandler() throws IOException {
    serverSocket.closeAfterConnections(1);
    server.start();
    assertThat(protocolFactory.createCalled, is(greaterThanOrEqualTo(1)));
  }

  @Test
  @DisplayName("server will run a protocol handler made by the facotry passed to it")
  public void serverStartRunsProtocolHandler() throws IOException, InterruptedException {
    serverSocket.closeAfterConnections(1);
    server.start();
    Thread.sleep(500);
    assertThat(threadedProcedure.runCalled, is(greaterThanOrEqualTo(1)));
  }
}

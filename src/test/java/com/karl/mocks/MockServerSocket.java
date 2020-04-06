package com.karl.mocks;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MockServerSocket extends ServerSocket {
  public MockSocket socket = new MockSocket();

  public MockServerSocket() throws IOException {
  }

  public Socket accept() {
    return socket;
  }
}

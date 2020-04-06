package com.karl.mocks;

import java.io.IOException;
import java.net.Socket;
import com.karl.wrappers.WrappedServerSocket;

public class MockServerSocket implements WrappedServerSocket {
  public MockSocket socket = new MockSocket();

  public MockServerSocket() throws IOException {
  }

  public Socket accept() {
    return socket;
  }

  public void close() {
  }
}

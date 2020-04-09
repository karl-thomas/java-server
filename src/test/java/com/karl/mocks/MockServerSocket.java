package com.karl.mocks;

import java.io.IOException;
import com.karl.wrappers.WrappedServerSocket;
import com.karl.wrappers.WrappedSocket;

public class MockServerSocket implements WrappedServerSocket {
  public MockSocketWrapper socket = new MockSocketWrapper();
  public boolean closeHasBeenCalled = false;

  public MockServerSocket() throws IOException {
  }

  public WrappedSocket accept() {
    return socket;
  }

  public void close() {
    closeHasBeenCalled = true;
  }

  public boolean isClosed() {
    return closeHasBeenCalled;
  }
}

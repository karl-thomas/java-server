package com.karl.mocks;

import java.io.IOException;
import com.karl.wrappers.WrappedServerSocket;
import com.karl.wrappers.WrappedSocket;

public class MockServerSocket implements WrappedServerSocket {
  public MockSocketWrapper socket = new MockSocketWrapper();
  public int acceptCallCount = 0;
  public int acceptCallLimit = 10;
  public boolean closeHasBeenCalled = false;

  public MockServerSocket() throws IOException {
  }

  public WrappedSocket accept() {
    this.acceptCallCount = this.acceptCallCount + 1;
    if (acceptCallCount >= acceptCallLimit) {
      close();
    }
    return socket;
  }

  public void close() {
    closeHasBeenCalled = true;
  }

  public boolean isClosed() {
    return closeHasBeenCalled;
  }

  public void closeAfterConnections(int timesAcceptIsCalled) {
    this.acceptCallLimit = timesAcceptIsCalled;
  }
}

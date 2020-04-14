package com.karl.mocks;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.karl.wrappers.WrappedServerSocket;
import com.karl.wrappers.WrappedSocket;

public class MockServerSocket implements WrappedServerSocket {
  public MockSocketWrapper socket = new MockSocketWrapper();
  public int acceptCallCount = 0;
  public boolean closeHasBeenCalled = false;

  public MockServerSocket() throws IOException {
  }

  public WrappedSocket accept() {
    acceptCallCount++;
    return socket;
  }

  public void close() {
    closeHasBeenCalled = true;
  }

  public boolean isClosed() {
    return closeHasBeenCalled;
  }

  public void closeAfterConnections(int timesAcceptIsCalled) {
    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    executorService.scheduleAtFixedRate(() -> {
      if (acceptCallCount >= timesAcceptIsCalled)
        close();
    }, 0, 10, TimeUnit.MILLISECONDS);
  }
}

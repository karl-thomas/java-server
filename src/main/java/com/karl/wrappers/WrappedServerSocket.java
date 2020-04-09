package com.karl.wrappers;

import java.io.IOException;

public interface WrappedServerSocket {
  public WrappedSocket accept() throws IOException;

  public void close() throws IOException;

  public boolean isClosed();
}

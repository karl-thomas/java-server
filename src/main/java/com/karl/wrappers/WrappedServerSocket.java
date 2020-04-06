package com.karl.wrappers;

import java.io.IOException;
import java.net.Socket;

public interface WrappedServerSocket {
  public Socket accept() throws IOException;

  public void close() throws IOException;
}

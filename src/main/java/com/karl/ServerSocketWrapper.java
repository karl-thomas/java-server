package com.karl;

import java.io.IOException;
import java.net.ServerSocket;
import com.karl.wrappers.WrappedServerSocket;
import com.karl.wrappers.WrappedSocket;

public class ServerSocketWrapper implements WrappedServerSocket {
  private ServerSocket serverSocket;

  public ServerSocketWrapper(int port) throws IOException {
    this.serverSocket = new ServerSocket(port);
  }

  public WrappedSocket accept() throws IOException {
    return new SocketWrapper(serverSocket.accept());
  }

  public void close() throws IOException {
    serverSocket.close();
  }
}

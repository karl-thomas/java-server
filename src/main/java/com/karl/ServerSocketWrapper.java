package com.karl;

import java.io.IOException;
import java.net.ServerSocket;
import com.karl.wrappers.Connectable;
import com.karl.wrappers.ServerSocketable;

public class ServerSocketWrapper implements ServerSocketable {
  private ServerSocket serverSocket;

  public ServerSocketWrapper(int port) throws IOException {
    this.serverSocket = new ServerSocket(port);
  }

  public Connectable accept() throws IOException {
    return new ClientConnection(serverSocket.accept());
  }

  public void close() throws IOException {
    serverSocket.close();
  }

  public boolean isClosed() {
    return serverSocket.isClosed();
  }
}

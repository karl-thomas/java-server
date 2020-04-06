package com.karl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import com.karl.wrappers.WrappedServerSocket;



public class ServerSocketWrapper implements WrappedServerSocket {
  private ServerSocket serverSocket;

  public ServerSocketWrapper(int port) throws IOException {
    this.serverSocket = new ServerSocket(port);
  }

  public Socket accept() throws IOException {
    return serverSocket.accept();
  }

  public void close() throws IOException {
    serverSocket.close();
  }
}

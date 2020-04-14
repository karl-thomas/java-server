package com.karl;

import java.io.IOException;
import com.karl.wrappers.WrappedServerSocket;
import com.karl.wrappers.WrappedSocket;

public class Server {
  private final WrappedServerSocket serverSocket;
  private WrappedSocket clientSocket;

  public Server(WrappedServerSocket serverSocket) {
    this.serverSocket = serverSocket;
  }

  public void start() throws IOException {
    while (!serverSocket.isClosed()) {
      clientSocket = accept();
      EchoHandler handler = new EchoHandler(clientSocket);
      new Thread(handler).start();
    }
  }

  public WrappedSocket accept() throws IOException {
    return serverSocket.accept();
  }

  public void close() throws IOException {
    if (clientSocket != null)
      clientSocket.close();
    if (serverSocket != null)
      serverSocket.close();
  }
}

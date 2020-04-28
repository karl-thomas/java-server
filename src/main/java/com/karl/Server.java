package com.karl;

import java.io.IOException;
import com.karl.wrappers.Connectable;
import com.karl.wrappers.ServerSocketable;

public class Server {
  private final ServerSocketable serverSocket;
  private Connectable connection;
  private ProtocolFactoryable handlerFactory;

  public Server(ServerSocketable serverSocket, ProtocolFactoryable handlerFactory) {
    this.serverSocket = serverSocket;
    this.handlerFactory = handlerFactory;
  }

  public void start() throws IOException {
    while (!serverSocket.isClosed()) {
      connection = accept();
      Runnable handler = handlerFactory.create(connection);
      new Thread(handler).start();
    }
  }

  public Connectable accept() throws IOException {
    return serverSocket.accept();
  }

  public void close() throws IOException {
    if (connection != null)
      connection.close();
    if (serverSocket != null)
      serverSocket.close();
  }
}

package com.karl;

import java.io.BufferedReader;
import java.io.IOException;
import com.karl.wrappers.WrappedServerSocket;
import com.karl.wrappers.WrappedSocket;

public class Server {
  private final WrappedServerSocket serverSocket;
  private WrappedSocket clientSocket;

  public Server(final WrappedServerSocket serverSocket) {
    this.serverSocket = serverSocket;
  }

  public void start() throws IOException {
    while (!serverSocket.isClosed()) {
      clientSocket = accept();
      final BufferedReader requestReader = clientSocket.getReader();
      String inputLine;
      while ((inputLine = requestReader.readLine()) != null) {
        clientSocket.write(inputLine);
      }
      clientSocket.close();
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

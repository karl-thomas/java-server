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
    clientSocket = accept();
    final BufferedReader in = clientSocket.getReader();
    String inputLine;
    while ((inputLine = in.readLine()) != null) {
      clientSocket.write(inputLine);
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

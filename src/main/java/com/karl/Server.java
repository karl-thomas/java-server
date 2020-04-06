package com.karl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  private ServerSocket serverSocket;
  private Socket clientSocket;
  private PrintWriter out;
  private BufferedReader in;

  public Server(ServerSocket serverSocket) {
    this.serverSocket = serverSocket;
  }

  public void start() throws IOException {
    clientSocket = accept();
    out = new PrintWriter(clientSocket.getOutputStream(), true);
    in = createRequestFrom(clientSocket);

    String inputLine;
    while ((inputLine = in.readLine()) != null) {
      out.println(inputLine);
    }
  }

  public Socket accept() throws IOException {
    return serverSocket.accept();
  }

  public BufferedReader createRequestFrom(Socket socket) throws IOException {
    return new BufferedReader(new InputStreamReader(socket.getInputStream()));
  }

  public void close() throws IOException {
    in.close();
    out.close();
    clientSocket.close();
    serverSocket.close();
  }
}

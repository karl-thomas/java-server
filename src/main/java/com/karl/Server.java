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
    in = createRequestFrom(clientSocket);
    String inputLine;
    while ((inputLine = in.readLine()) != null) {
      writeTo(clientSocket, inputLine);
    }
  }

  public void writeTo(Socket socket, String message) throws IOException {
    getWriterFor(socket).println(message);
  }

  public Socket accept() throws IOException {
    return serverSocket.accept();
  }

  public BufferedReader createRequestFrom(Socket socket) throws IOException {
    return new BufferedReader(new InputStreamReader(socket.getInputStream()));
  }

  private PrintWriter getWriterFor(Socket socket) throws IOException {
    return new PrintWriter(socket.getOutputStream(), true);
  }

  public void close() throws IOException {
    if (in != null)
      in.close();
    if (out != null)
      out.close();
    if (clientSocket != null)
      clientSocket.close();
    if (serverSocket != null)
      serverSocket.close();
  }
}

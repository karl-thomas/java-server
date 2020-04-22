package com.karl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import com.karl.wrappers.WrappedSocket;

public class SocketWrapper implements WrappedSocket {
  private Socket socket;
  private BufferedReader requestReader;
  private PrintWriter responseWriter;

  public SocketWrapper(Socket socket) throws IOException {
    this.socket = socket;
    this.requestReader = this.createRequestReader(socket);
    this.responseWriter = this.createWriterFor(socket);
  }

  public void write(String message) throws IOException {
    PrintWriter writer = getWriter();
    writer.print(message);
    System.out.println("buffered up: " + message);
    writer.flush();
  }

  public void close() throws IOException {
    socket.close();
    requestReader.close();
    responseWriter.close();
  }

  public PrintWriter getWriter() {
    return this.responseWriter;
  }

  public BufferedReader getReader() {
    return this.requestReader;
  }

  private BufferedReader createRequestReader(Socket socket) throws IOException {
    return new BufferedReader(new InputStreamReader(socket.getInputStream()));
  }

  private PrintWriter createWriterFor(Socket socket) throws IOException {
    return new PrintWriter(socket.getOutputStream(), true);
  }
}

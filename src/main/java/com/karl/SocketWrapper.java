package com.karl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.function.Function;
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
    getWriter().println(message);
  }

  public void close() throws IOException {
    socket.close();
    requestReader.close();
    responseWriter.close();
  }

  // karls ideal <3
  // public void handle(Function func) {
  // write(func(getReader));
  // }

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

package com.karl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import com.karl.wrappers.Connectable;
import com.karl.wrappers.Socketable;

public class ClientConnection implements Connectable {
  private Socketable socket;
  private BufferedReader requestReader;
  private PrintWriter responseWriter;

  public ClientConnection(Socket socket) throws IOException {
    this.socket = new WrappedSocket(socket);
    this.requestReader = this.createRequestReader(this.socket);
    this.responseWriter = this.createWriterFor(this.socket);
  }

  public ClientConnection(Socketable socket) throws IOException {
    this.socket = socket;
    this.requestReader = this.createRequestReader(socket);
    this.responseWriter = this.createWriterFor(socket);
  }

  public void write(String message) throws IOException {
    PrintWriter writer = getWriter();
    writer.print(message);
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

  private BufferedReader createRequestReader(Socketable socket) throws IOException {
    return new BufferedReader(new InputStreamReader(socket.in()));
  }

  private PrintWriter createWriterFor(Socketable socket) throws IOException {
    return new PrintWriter(socket.out(), true);
  }
}

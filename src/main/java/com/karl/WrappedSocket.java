package com.karl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import com.karl.wrappers.Socketable;

public class WrappedSocket implements Socketable {
  private Socket socket;

  public WrappedSocket(Socket socket) {
    this.socket = socket;
  }

  public InputStream in() throws IOException {
    return socket.getInputStream();
  }

  public OutputStream out() throws IOException {
    return socket.getOutputStream();
  }

  public void close() throws IOException {
    socket.close();
  }
}

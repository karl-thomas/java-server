package com.karl;

import java.io.BufferedReader;
import com.karl.wrappers.WrappedSocket;

public class EchoHandler implements Runnable {
  public WrappedSocket socket;

  public EchoHandler(WrappedSocket socket) {
    this.socket = socket;
  }

  public void run() {
    try {
      final BufferedReader requestReader = socket.getReader();
      String inputLine;
      while ((inputLine = requestReader.readLine()) != null) {
        socket.write(inputLine);
      }
      socket.close();
    } catch (Exception e) {
      System.out.print(e);
    }
  }
}

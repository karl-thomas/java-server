package com.karl.http;

import java.io.BufferedReader;
import com.karl.constants.Globals;
import com.karl.wrappers.WrappedSocket;

public class HTTPHandler implements Runnable {
  public WrappedSocket socket;

  public HTTPHandler(WrappedSocket socket) {
    this.socket = socket;
  }

  public void run() {
    try {
      final BufferedReader requestReader = socket.getReader();
      String requestString = "";
      while (requestReader.ready()) {
        requestString = requestString + requestReader.readLine();
      }
      HTTPRequest request = new HTTPRequest(requestString);

      if (request.getMethod().equals("GET") && request.getRoute().equals("/simple_get")) {
        socket.write("HTTP/1.1 200 OK" + Globals.CRLF + Globals.CRLF);
      }

      socket.close();
    } catch (Exception e) {
      System.out.print(e);
    }
  }
}

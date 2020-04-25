package com.karl.http;

import java.io.BufferedReader;
import java.io.IOException;
import com.karl.constants.Globals;
import com.karl.wrappers.WrappedSocket;

public class HTTPHandler implements Runnable {
  private WrappedSocket socket;

  public HTTPHandler(WrappedSocket socket) {
    this.socket = socket;
  }

  public String createRequestString() throws IOException {
    final BufferedReader requestReader = socket.getReader();
    StringBuilder builder = new StringBuilder();

    while (requestReader.ready()) {
      builder.append(requestReader.readLine());
    }

    return builder.toString();
  }

  public void run() {
    try {
      String requestString = createRequestString();
      HTTPRequestBuilder builder = new HTTPRequestBuilder();
      builder.withRequestString(requestString);
      HTTPRequest request = builder.build();

      if (request.method().equals("GET") && request.path().equals("/simple_get")) {
        socket.write("HTTP/1.1 200 OK" + Globals.CRLF + Globals.CRLF);
      }

      socket.close();
    } catch (Exception e) {
      System.out.print(e);
    }
  }
}

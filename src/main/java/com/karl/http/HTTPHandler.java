package com.karl.http;

import java.io.BufferedReader;
import java.io.IOException;
import com.karl.constants.Globals;
import com.karl.wrappers.Connectable;

public class HTTPHandler implements Runnable {
  private Connectable connection;

  public HTTPHandler(Connectable connection) {
    this.connection = connection;
  }

  public String createRequestString() throws IOException {
    final BufferedReader requestReader = connection.getReader();
    StringBuilder builder = new StringBuilder();

    while (requestReader.ready()) {
      builder.append(requestReader.readLine());
    }

    return builder.toString();
  }

  public void run() {
    try {
      String requestString = createRequestString();
      HTTPRequest request = new HTTPRequestBuilder().withRequestString(requestString).build();

      if (request.methodIs(HTTPMethod.GET) && request.path().equals("/simple_get")) {
        connection.write("HTTP/1.1 200 OK" + Globals.CRLF + Globals.CRLF);
      }

      connection.close();
    } catch (Exception e) {
      System.out.print(e);
    }
  }
}

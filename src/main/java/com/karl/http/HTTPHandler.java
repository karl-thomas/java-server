package com.karl.http;

import com.karl.constants.Globals;
import com.karl.wrappers.Connectable;

public class HTTPHandler implements Runnable {
  private Connectable connection;

  public HTTPHandler(Connectable connection) {
    this.connection = connection;
  }

  public String createRequestString(String statusLine, String headers, String body) {
    return new StringBuilder()
        .append(statusLine)
        .append(Globals.CRLF)
        .append(headers)
        .append(Globals.CRLF)
        .append(body)
        .toString();
  }

  public void run() {
    try {
      HTTPRequest request = new HTTPRequestBuilder().withConnection(connection).build();

      if (request.methodIs(HTTPMethod.GET) && request.path().equals("/simple_get")) {
        connection.write(createRequestString("HTTP/1.1 200 OK", "", ""));
      } else if (request.methodIs(HTTPMethod.GET) && request.path().equals("/simple_get_with_body")) {
        connection.write(createRequestString("HTTP/1.1 200 OK", "", "Hello world"));
      } else if (request.methodIs(HTTPMethod.GET) && request.path().equals("/head_request")) {
        connection
            .write(createRequestString("HTTP/1.1 405 Method Not Found", "Allow: HEAD, OPTIONS" + Globals.CRLF, ""));
      } else {
        connection.write(createRequestString("HTTP/1.1 404 Not Found", "", ""));
      }

      connection.close();
    } catch (Exception e) {
      System.out.print(e);
    }
  }
}

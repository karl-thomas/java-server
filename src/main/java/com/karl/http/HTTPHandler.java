package com.karl.http;

import com.karl.constants.Globals;
import com.karl.wrappers.Connectable;

public class HTTPHandler implements Runnable {
  private Connectable connection;

  public HTTPHandler(Connectable connection) {
    this.connection = connection;
  }

  public void run() {
    try {
      HTTPRequest request = new HTTPRequestBuilder().withConnection(connection).build();

      if (request.methodIs(HTTPMethod.GET) && request.path().equals("/simple_get")) {
        connection.write("HTTP/1.1 200 OK" + Globals.CRLF + Globals.CRLF);
      } else if (request.methodIs(HTTPMethod.GET)
          && request.path().equals("/simple_get_with_body")) {
        connection.write("HTTP/1.1 200 OK" + Globals.CRLF + Globals.CRLF + "Hello world");
      } else if (request.methodIs(HTTPMethod.GET) && request.path().equals("/head_request")) {
        connection.write("HTTP/1.1 405 Method Not Allowed" + Globals.CRLF + "Allow: HEAD, OPTIONS"
            + Globals.CRLF + Globals.CRLF);
      } else {
        connection.write("HTTP/1.1 404 Not Found" + Globals.CRLF + Globals.CRLF);
      }

      connection.close();
    } catch (Exception e) {
      System.out.print(e);
    }
  }
}

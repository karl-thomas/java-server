package com.karl.http;

import java.io.IOException;
import com.karl.constants.Globals;

class HTTPRequestBuilder {
  private HTTPMethod method = HTTPMethod.INVALID;
  private String path = "";

  public void withMethod(String method) {
    withMethod(HTTPMethod.fromString(method));
  }

  public void withMethod(HTTPMethod method) {
    this.method = method;
  }

  public void withPath(String path) {
    this.path = path;
  }

  public HTTPRequest build() {
    return new HTTPRequest(method, path);
  }

  public void withRequestString(String request) throws IOException {
    String[] lines = request.split(Globals.CRLF);
    String requestLine = lines[0];
    String[] elements = requestLine.split(" ");
    withMethod(HTTPMethod.fromString(elements[0]));
    withPath(elements[1]);
  }
}

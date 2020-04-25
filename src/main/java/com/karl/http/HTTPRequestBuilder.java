package com.karl.http;

import java.io.IOException;
import com.karl.constants.Globals;

class HTTPRequestBuilder {
  private String method = "";
  private String path = "";

  public void withMethod(String method) {
    this.method = method;
  }

  public void withPath(String method) {
    this.path = method;
  }

  public HTTPRequest build() {
    return new HTTPRequest(method, path);
  }

  public void withRequestString(String request) throws IOException {
    String[] lines = request.split(Globals.CRLF);
    String requestLine = lines[0];
    String[] elements = requestLine.split(" ");
    withMethod(elements[0]);
    withPath(elements[1]);
  }
}

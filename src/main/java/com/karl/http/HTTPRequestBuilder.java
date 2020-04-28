package com.karl.http;

import java.io.IOException;
import com.karl.constants.Globals;
import com.karl.wrappers.Connectable;

class HTTPRequestBuilder {
  private HTTPMethod method = HTTPMethod.INVALID;
  private String path = "";

  public HTTPRequestBuilder withMethod(String method) {
    return withMethod(HTTPMethod.fromString(method));
  }

  public HTTPRequestBuilder withMethod(HTTPMethod method) {
    this.method = method;
    return this;
  }

  public HTTPRequestBuilder withPath(String path) {
    this.path = path;
    return this;
  }

  public HTTPRequest build() {
    return new HTTPRequest(method, path);
  }

  public HTTPRequestBuilder withRequestString(String request) throws IOException {
    String[] lines = request.split(Globals.CRLF);
    withRequestLine(lines[0]);

    return this;
  }

  public HTTPRequestBuilder withConnection(Connectable connection) throws IOException {
    String requestLine = connection.readUntil(Globals.CRLF);
    withRequestLine(requestLine);

    return this;
  }

  public HTTPRequestBuilder withRequestLine(String requestLine) {
    String[] elements = requestLine.split(" ");
    withMethod(HTTPMethod.fromString(elements[0]));
    withPath(elements[1]);
    return this;
  }
}

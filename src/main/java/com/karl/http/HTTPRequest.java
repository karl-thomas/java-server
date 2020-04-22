package com.karl.http;

import com.karl.constants.Globals;

public class HTTPRequest {
  private String method;
  private String route;

  public HTTPRequest(String request) {
    String[] lines = request.split(Globals.CRLF);
    String requestLine = lines[0];
    String[] elements = requestLine.split(" ");
    method = elements[0];
    route = elements[1];
  }

  public String getMethod() {
    return method;
  }

  public String getRoute() {
    return route;
  }
}

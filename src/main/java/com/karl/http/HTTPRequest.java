package com.karl.http;

import com.karl.constants.Globals;

public class HTTPRequest {
  private String method;
  private String path;

  public HTTPRequest(String request) {
    String[] lines = request.split(Globals.CRLF);
    String requestLine = lines[0];
    String[] elements = requestLine.split(" ");
    method = elements[0];
    path = elements[1];
  }

  public HTTPRequest(String method, String path) {
    this.method = method;
    this.path = path;
  }

  public String getMethod() {
    return method;
  }

  public String getPath() {
    return path;
  }
}

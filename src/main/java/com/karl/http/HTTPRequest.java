package com.karl.http;

public class HTTPRequest {
  private String method;
  private String path;

  public HTTPRequest(String method, String path) {
    this.method = method;
    this.path = path;
  }

  public String method() {
    return method;
  }

  public String path() {
    return path;
  }
}

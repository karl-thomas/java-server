package com.karl.http;

public class HTTPRequest {
  private HTTPMethod method;
  private String path;

  public HTTPRequest(HTTPMethod method, String path) {
    this.method = method;
    this.path = path;
  }

  public HTTPMethod method() {
    return method;
  }

  public String path() {
    return path;
  }

  public boolean methodIs(HTTPMethod methodToCompare) {
    return this.method.equals(methodToCompare);
  }
}

package com.karl.http;

class HTTPRequestBuilder {
  private String method = "";
  private String path = "";

  public void withMethod(String method) {
    this.method = method;
  }

  public void withPath(String method) {
    this.method = method;
  }

  public HTTPRequest build() {
    return new HTTPRequest(method, path);
  }
}

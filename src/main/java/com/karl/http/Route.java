package com.karl.http;

public class Route {
  public HTTPMethod expectedMethod;
  public String path;
  public String response;

  public Route(HTTPMethod expectedMethod, String path, String response) {
    this.expectedMethod = expectedMethod;
    this.path = path;
    this.response = response;
  }

  public boolean match(HTTPRequest request) {
    return request.methodIs(expectedMethod) && request.path() == path;
  }
}

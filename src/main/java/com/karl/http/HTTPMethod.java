package com.karl.http;

public enum HTTPMethod {
  OPTIONS, GET, HEAD, POST, PUT, DELETE, INVALID;

  public static HTTPMethod fromString(String value) {
    try {
      return HTTPMethod.valueOf(value);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      return INVALID;
    }
  }
}

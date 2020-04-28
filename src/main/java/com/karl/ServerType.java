package com.karl;

public enum ServerType {
  echo, http, notFound;

  public static ServerType fromString(String value) {
    try {
      return ServerType.valueOf(value);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
      return notFound;
    }
  }
}

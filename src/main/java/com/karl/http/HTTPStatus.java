package com.karl.http;

public enum HTTPStatus {
  Ok("200", "Ok"),
  NotFound("404", "Not Found"),
  MethodNotAllowed("405", "Not Found");

  public String code;
  public String reasonPhrase;

  private HTTPStatus(String code, String reasonPhrase) {
    this.code = code;
    this.reasonPhrase = reasonPhrase;
  }

  @Override
  public String toString() {
    return code + " " + reasonPhrase;
  }
}

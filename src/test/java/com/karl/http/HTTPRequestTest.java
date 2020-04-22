package com.karl.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.karl.constants.Globals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HTTPRequestTest {
  String simpleGet = String.format("GET /simple_get HTTP/1.1%s%s", Globals.CRLF, Globals.CRLF);

  @Test
  @DisplayName("method returns the https method from the request line")
  public void methodReturnsValueFromRequestLine() {
    final HTTPRequest request = new HTTPRequest(simpleGet);
    assertEquals("GET", request.getMethod());
  }

  @Test
  @DisplayName("route returns the https method from the request line")
  public void routeReturnsValueFromRequestLine() {
    final HTTPRequest request = new HTTPRequest(simpleGet);
    assertEquals("/simple_get", request.getRoute());
  }
}

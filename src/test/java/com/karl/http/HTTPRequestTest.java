package com.karl.http;

import com.karl.constants.Globals;
import static org.junit.jupiter.api.Assertions.assertFalse;
// import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HTTPRequestTest {
  String simpleGet = String.format("GET /simple_get HTTP/1.1%s%s", Globals.CRLF, Globals.CRLF);

  @Test
  @DisplayName("methodIs returns true if the request method type matches the one given")
  public void methodIsReturnsTrueIfParamMatchesInnerMethod() {
    HTTPMethod method = HTTPMethod.GET;
    HTTPRequest request = new HTTPRequest(method, "");
    assertTrue(request.methodIs(method));
    assertTrue(request.methodIs(HTTPMethod.GET));
  }

  @Test
  @DisplayName("methodIs returns false if the request method does not match the one given")
  public void methodIsReturnsFalseIfParamDoesNotMatchInnerMethod() {
    HTTPMethod method = HTTPMethod.DELETE;
    HTTPRequest request = new HTTPRequest(method, "");
    assertFalse(request.methodIs(HTTPMethod.GET));
  }

}

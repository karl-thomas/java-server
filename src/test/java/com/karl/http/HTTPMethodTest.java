package com.karl.http;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
// import org.hamcrest.BaseMatcher;


public class HTTPMethodTest {
  @Test
  @DisplayName("fromString returns a HTTPMethod if one of its enums matches the argument")
  public void validCallTofromStringReturnsAHTTPmethod() {
    assertThat(HTTPMethod.fromString("GET"), equalTo(HTTPMethod.GET));
  }

  @Test
  @DisplayName("fromString returns HTTPMethod.INVALID if the string does not matchone of the enum values")
  public void invalidStringtoFromStringReutrnINVALID() {
    assertThat(HTTPMethod.fromString("not a method!"), equalTo(HTTPMethod.INVALID));
    assertThat(HTTPMethod.fromString("Get"), equalTo(HTTPMethod.INVALID));
    assertThat(HTTPMethod.fromString("GT"), equalTo(HTTPMethod.INVALID));
  }
}

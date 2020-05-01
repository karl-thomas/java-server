package com.karl.http;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class RouteTest {
  @Test
  public void matchReturnsTrueIfTheMethodandPAthOftheRequestMatchesExpectedValues() {
    Route route = new Route(HTTPMethod.GET, "/heyo", "hello");
    HTTPRequest request = new HTTPRequest(HTTPMethod.GET, "/heyo");
    assertTrue(route.match(request));
  }

}

package com.karl.http;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import com.karl.constants.Globals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class HTTPRequestBuilderTest {
  String simpleGet = String.format("GET /simple_get HTTP/1.1%s%s", Globals.CRLF, Globals.CRLF);

  @Test
  @DisplayName("build will output an HTTPRequest with whatever data it has")
  public void buildReturnsHTTPRequest() {
    HTTPRequest request = new HTTPRequestBuilder().build();
    assertThat(request.method(), equalTo(HTTPMethod.INVALID));
    assertThat(request.path(), equalTo(""));
  }

  @Nested
  public class withMethod {
    @Test
    @DisplayName("set the HTTP method for the request to be built")
    public void withMethodSetsRequestMethod() {
      HTTPRequest request = new HTTPRequestBuilder().withMethod("GET").build();
      assertThat(request.method(), equalTo(HTTPMethod.GET));
    }
  }

  @Test
  @DisplayName("withPath will set the HTTP path for the request to be built")
  public void withPathSetsRequestPath() {
    HTTPRequest request = new HTTPRequestBuilder().withPath("/hey_there").build();
    assertThat(request.path(), equalTo("/hey_there"));
  }

  @Nested
  public class withRequestString {
    @Test
    @DisplayName("parses the right method from a stringified request")
    public void returnsMethodValueFromRequestLine() throws IOException {
      final HTTPRequest request = new HTTPRequestBuilder().withRequestString(simpleGet).build();
      assertThat(request.method(), equalTo(HTTPMethod.GET));
    }

    @Test
    @DisplayName("parses the right path from a stringified request")
    public void returnsPathValueFromRequestLine() throws IOException {
      final HTTPRequest request = new HTTPRequestBuilder().withRequestString(simpleGet).build();
      assertThat(request.path(), equalTo("/simple_get"));
    }
  }
}

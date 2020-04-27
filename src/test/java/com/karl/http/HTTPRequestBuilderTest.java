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
    HTTPRequestBuilder builder = new HTTPRequestBuilder();
    assertThat(builder.build().method(), equalTo(""));
    assertThat(builder.build().path(), equalTo(""));
  }

  @Nested
  public class withMEthod {
    @Test
    @DisplayName("set the HTTP method for the request to be built")
    public void withMethodSetsRequestMethod() {
      HTTPRequestBuilder builder = new HTTPRequestBuilder();
      builder.withMethod("GET");
      assertThat(HTTPMethod.GET, equalTo(builder.build().method()));
    }
  }

  @Test
  @DisplayName("withPath will set the HTTP path for the request to be built")
  public void withPathSetsRequestPath() {
    HTTPRequestBuilder builder = new HTTPRequestBuilder();
    builder.withPath("/hey_there");
    assertThat(builder.build().path(), equalTo("/hey_there"));
  }

  @Nested
  public class withRequestString {
    @Test
    @DisplayName("parses the right method from a stringified request")
    public void returnsMethodValueFromRequestLine() throws IOException {
      final HTTPRequestBuilder builder = new HTTPRequestBuilder();
      builder.withRequestString(simpleGet);
      assertThat(builder.build().method(), equalTo("GET"));
    }

    @Test
    @DisplayName("parses the right path from a stringified request")
    public void returnsPathValueFromRequestLine() throws IOException {
      final HTTPRequestBuilder builder = new HTTPRequestBuilder();
      builder.withRequestString(simpleGet);
      assertThat(builder.build().path(), equalTo("/simple_get"));
    }
  }
}

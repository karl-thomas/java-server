package com.karl.http;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HTTPRequestBuilderTest {
  @Test
  @DisplayName("build will output an HTTPRequest with whatever data it has")
  public void buildReturnsHTTPRequest() {
    HTTPRequestBuilder builder = new HTTPRequestBuilder();
    assertThat(builder.build().getMethod(), equalTo(""));
    assertThat(builder.build().getPath(), equalTo(""));
  }

  @Test
  @DisplayName("withMethod will set the HTTP method for the request to be built")
  public void withMethodSetsRequestMethod() {
    HTTPRequestBuilder builder = new HTTPRequestBuilder();
    builder.withMethod("GET");
    assertThat(builder.build().getMethod(), equalTo("GET"));
  }

  @Test
  @DisplayName("withPath will set the HTTP path for the request to be built")
  public void withPathSetsRequestPath() {
    HTTPRequestBuilder builder = new HTTPRequestBuilder();
    builder.withPath("/hey_there");
    assertThat(builder.build().getPath(), equalTo("/hey_there"));
  }
}

package com.karl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServerTypeTest {
  @Test
  @DisplayName("'echo' passed to fromString returns ServerType.echo")
  public void echoToFromStringReturnCorrectType() {
    assertThat(ServerType.fromString("echo"), equalTo(ServerType.echo));
  }

  @Test
  @DisplayName("'http' passed to fromString returns ServerType.http")
  public void httpToFromStringReturnCorrectType() {
    assertThat(ServerType.fromString("http"), equalTo(ServerType.http));
  }

  @Test
  @DisplayName("anything thats not a valid Servertype passed to fromString returns 'notFound'")
  public void invalidStringtoFromStringReturnsNotFound() {
    assertThat(ServerType.fromString("not a type!"), equalTo(ServerType.notFound));
  }
}

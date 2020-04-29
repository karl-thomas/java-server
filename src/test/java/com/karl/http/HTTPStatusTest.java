package com.karl.http;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HTTPStatusTest {
  @Test
  public void toStringReturnsTheCodeAndTheReasonPhraseSeperatedByAString() {
    HTTPStatus ok = HTTPStatus.Ok;
    assertThat(ok.code, equalTo("200"));
    assertThat(ok.reasonPhrase, equalTo("Ok"));
    assertThat(ok.toString(), equalTo("200 Ok"));
  }

  @Test
  public void aStatusCodeCanBeinterpolatedWithOtherStrings() {
    HTTPStatus ok = HTTPStatus.Ok;
    String result = String.format("sand%swich", ok);
    assertThat(result, containsString("d200 Okw"));
  }
}

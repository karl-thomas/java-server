package com.karl.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import com.karl.constants.Globals;
import com.karl.mocks.MockConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HTTPHandlerTest {
  String simpleGet = "GET /simple_get HTTP/1.1" + Globals.CRLF + Globals.CRLF;
  String simpleGetWithBody = simpleGet + "heyo it's a body!!";

  @Test
  @DisplayName("handler will respond with a 200 okay when a Get request is made to /simple_get")
  public void respond200toSimpleGet() throws IOException {
    MockConnection mocket = new MockConnection(simpleGet);
    HTTPHandler handler = new HTTPHandler(mocket);
    handler.run();
    String result = mocket.sentToClient();
    String response = "HTTP/1.1 200 OK" + Globals.CRLF + Globals.CRLF;
    assertEquals(response, result);
  }

  @Test
  public void createRequestStringWillCombineAStatusHeaderAndABodySeperatedByCRLFs() {
    MockConnection mocket = new MockConnection(simpleGet);
    HTTPHandler handler = new HTTPHandler(mocket);
    String statusLine = "hey I'm the status line";
    String headers = "and I'm the headers";
    String body = "and I'm the only one in the right format!";

    String result = handler.createRequestString(statusLine, headers, body);
    assertThat(result, containsString(statusLine + Globals.CRLF));
    assertThat(result, containsString(Globals.CRLF + headers + Globals.CRLF));
    assertThat(result, containsString(Globals.CRLF + body));
    assertThat(result, containsString(statusLine + Globals.CRLF + headers + Globals.CRLF + body));
  }
}


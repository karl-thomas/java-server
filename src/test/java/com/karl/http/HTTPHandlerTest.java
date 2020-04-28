package com.karl.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import com.karl.constants.Globals;
import com.karl.mocks.MockConnection;
import com.karl.wrappers.Connectable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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

  @Nested
  public class createRequestStringMethod {
    @Test
    @DisplayName("should to parse a socket with a outputstream that has a request line into a string")
    public void parseHTTPNoBodyRequestIntoString() throws IOException {
      Connectable connection = new MockConnection(simpleGet);
      HTTPHandler handler = new HTTPHandler(connection);
      assertThat(handler.createRequestString(), equalToCompressingWhiteSpace(simpleGet));
    }
  }
}


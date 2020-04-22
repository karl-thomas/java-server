package com.karl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import com.karl.constants.Globals;
import com.karl.mocks.MockSocketWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HTTPHandlerTest {
  @Test
  @DisplayName("server will respond with a 200 okay when a Get request is made to /simple_get")
  public void respond200toSimpleGet() throws IOException {
    String simpleGet = "GET /simple_get HTTP/1.1" + Globals.CRLF + Globals.CRLF;
    MockSocketWrapper mocket = new MockSocketWrapper(simpleGet);
    HTTPHandler handler = new HTTPHandler(mocket);
    handler.run();
    String result = mocket.sentToClient();
    String response = "HTTP/1.1 200 OK" + Globals.CRLF + Globals.CRLF;
    assertEquals(response, result);
  }
}


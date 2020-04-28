package com.karl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import com.karl.constants.Globals;
import com.karl.mocks.MockSocket;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ClientConnectionTest {
  @Nested
  class closeMethod {
    @Test
    public void shouldCloseInnerSocket() throws IOException {
      MockSocket innerSocket = new MockSocket("google.com".getBytes());
      ClientConnection socket = new ClientConnection(innerSocket);
      socket.close();

      assertTrue(innerSocket.closeCalled);
    }

    @Test
    public void readUntilShouldGiveYouAllTheTextBeforeAndIncludingALimiter() throws IOException {
      String content = "oh buddy its a string with a clrf" + Globals.CRLF;
      String extra = "not this stuff oh nooooooo!!!";
      String searchString = content + extra;
      MockSocket innerSocket = new MockSocket(searchString.getBytes());
      ClientConnection socket = new ClientConnection(innerSocket);
      assertThat(socket.readUntil(Globals.CRLF), equalTo(content));
    }

    @Test
    public void readUntilShouldGiveYouTheWholeStringIfLimiterIsNotFound() throws IOException {
      String content =
          "oh buddy its a string with a clrf oh no what's going to happen!!" + Globals.CRLF;
      String extra = "i bet this stuff is in there woohoooooooooooo!!!";
      String searchString = content + extra;
      MockSocket innerSocket = new MockSocket(searchString.getBytes());
      ClientConnection socket = new ClientConnection(innerSocket);
      assertThat(socket.readUntil("01-not-in-there.wav"), equalTo(searchString));
    }
  }
}

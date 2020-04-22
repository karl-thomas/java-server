package com.karl.echo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import com.karl.mocks.MockSocketWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EchoHandlerTest {
  @Test
  @DisplayName("server will not write anything if the client didn't send anthing")
  public void serverWillNotRespondToNothing() throws IOException {
    String message = "";
    MockSocketWrapper mocket = new MockSocketWrapper(message);
    EchoHandler handler = new EchoHandler(mocket);
    handler.run();
    String result = mocket.sentToClient();

    assertEquals(message, result);
  }

  @Test
  @DisplayName("server writes the same message, to the client it was sent from")
  public void serverCanHandleARequest() throws IOException {
    String message = "howdy!";
    MockSocketWrapper mocket = new MockSocketWrapper(message);
    EchoHandler handler = new EchoHandler(mocket);
    handler.run();
    String result = mocket.sentToClient();

    assertEquals(message, result.trim());
  }
}

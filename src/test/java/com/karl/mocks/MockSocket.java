package com.karl.mocks;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MockSocket extends Socket {
  public String streamText = "default";

  public MockSocket() {
  }

  public InputStream getInputStream() {
    return new ByteArrayInputStream(streamText.getBytes());
  }

  public OutputStream getOutputStream() {
    return new OutputStream() {
      @Override
      public void write(int b) throws IOException {

      }
    };
  }
}

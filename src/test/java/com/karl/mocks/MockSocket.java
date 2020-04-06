package com.karl.mocks;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MockSocket extends Socket {
  private String streamText = "default";

  public String getStreamText() {
    return this.streamText;
  }

  public void setStreamText(String StreamText) {
    this.streamText = StreamText;
  }

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

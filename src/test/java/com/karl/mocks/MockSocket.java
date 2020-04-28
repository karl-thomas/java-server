package com.karl.mocks;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import com.karl.wrappers.Socketable;

public class MockSocket implements Socketable {
  public boolean closeCalled = false;
  private InputStream data;
  private ByteArrayOutputStream output;

  public MockSocket(byte[] data) {
    this.data = new ByteArrayInputStream(data);
    this.output = new ByteArrayOutputStream();
  }

  public InputStream in() {
    return data;
  }

  public OutputStream out() {
    return output;
  }

  public String getInput() {
    return new String(this.output.toByteArray());
  }

  public void close() throws IOException {
    this.closeCalled = true;
  }
}

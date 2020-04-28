package com.karl.wrappers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Socketable {
  public InputStream in() throws IOException;

  public OutputStream out() throws IOException;

  public void close() throws IOException;
}

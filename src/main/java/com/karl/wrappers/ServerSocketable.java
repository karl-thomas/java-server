package com.karl.wrappers;

import java.io.IOException;

public interface ServerSocketable {
  public Connectable accept() throws IOException;

  public void close() throws IOException;

  public boolean isClosed();
}

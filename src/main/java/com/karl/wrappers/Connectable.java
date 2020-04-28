package com.karl.wrappers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public interface Connectable {
  public BufferedReader getReader();

  public PrintWriter getWriter();

  public void close() throws IOException;

  public void write(String message) throws IOException;
}

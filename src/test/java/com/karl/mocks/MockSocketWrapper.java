package com.karl.mocks;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import com.karl.wrappers.WrappedSocket;

public class MockSocketWrapper implements WrappedSocket {
  public PrintWriter responseWriter;
  public BufferedReader requestReader;
  public String textFromClient;
  private List<Byte> bytesList = new ArrayList<>();

  public MockSocketWrapper() {
    this.textFromClient = "default";
  }

  public MockSocketWrapper(String textFromClient) {
    this.textFromClient = textFromClient;
  }

  public void write(String message) throws IOException {
    getWriter().println(message);
  }

  public void close() throws IOException {
  }

  public PrintWriter getWriter() {
    return new PrintWriter(getOutputStream(), true);
  }

  public BufferedReader getReader() {
    return new BufferedReader(new InputStreamReader(getInputStream()));
  }

  public InputStream getInputStream() {
    return new ByteArrayInputStream(textFromClient.getBytes());
  }

  public OutputStream getOutputStream() {
    return new OutputStream() {
      @Override
      public void write(int b) throws IOException {
        bytesList.add((byte) b);
      }
    };
  }

  public String sentToClient() {
    return new String(toByteArray(bytesList));
  }

  private byte[] toByteArray(List<Byte> byteList) {
    byte[] byteArray = new byte[byteList.size()];
    for (int i = 0; i < byteArray.length; i++) {
      byteArray[i] = (byte) byteList.get(i);
    }
    return byteArray;
  }
}

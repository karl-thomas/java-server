package com.karl.mocks;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MockSocket extends Socket {
  private List<Byte> bytesList = new ArrayList<>();

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

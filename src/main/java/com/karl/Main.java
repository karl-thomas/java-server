package com.karl;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    int portNumber = 6666;
    Server server = new Server();
    server.start(portNumber);
  }
}

package com.karl;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
  public static void main(String[] args) throws IOException {
    ServerSocket socket = new ServerSocket(Globals.PORT);
    Server server = new Server(socket);
    server.start();
  }
}

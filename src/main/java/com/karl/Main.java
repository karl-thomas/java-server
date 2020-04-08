package com.karl;

import java.io.IOException;
import com.karl.constants.Globals;

public class Main {
  public static void main(String[] args) throws IOException {
    ServerSocketWrapper socket = new ServerSocketWrapper(Globals.PORT);
    Server server = new Server(socket);
    server.start();
  }
}

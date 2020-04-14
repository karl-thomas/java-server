package com.karl;

import java.io.IOException;
import com.karl.constants.Globals;
import com.karl.wrappers.WrappedServerSocket;

public class Main {
  public static void main(String[] args) throws IOException {
    WrappedServerSocket socket = new ServerSocketWrapper(Globals.PORT);
    Server server = new Server(socket);
    server.start();
  }
}

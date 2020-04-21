package com.karl;

import java.io.IOException;
import com.karl.constants.Globals;
import com.karl.wrappers.WrappedServerSocket;

public class Main {
  public static void main(String[] args) throws IOException {
    int port;
    try {
      port = Integer.parseInt(args[0]);
    } catch (Exception e) {
      port = Globals.PORT;
    }

    WrappedServerSocket socket = new ServerSocketWrapper(port);
    Server server = new Server(socket);
    server.start();
  }
}

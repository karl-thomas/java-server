package com.karl;

import java.io.IOException;
import com.karl.constants.Globals;
import com.karl.echo.EchoServer;
import com.karl.http.HTTPServer;
import com.karl.wrappers.WrappedServerSocket;

public class Main {
  public static void main(String[] args) throws IOException {
    int port;
    try {
      port = Integer.parseInt(args[0]);
    } catch (Exception e) {
      port = Globals.PORT;
    }

    String serverType;
    try {
      serverType = args[1];
    } catch (Exception e) {
      serverType = "http";
    }

    WrappedServerSocket socket = new ServerSocketWrapper(port);
    if (serverType.equals("echo")) {
      EchoServer server = new EchoServer(socket);
      server.start();
    } else if (serverType.equals("http")) {
      HTTPServer server = new HTTPServer(socket);
      server.start();
    }
  }
}

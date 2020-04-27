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

    ServerType serverType;
    try {
      serverType = ServerType.fromString(args[1]);
    } catch (Exception e) {
      serverType = ServerType.http;
    }

    WrappedServerSocket socket = new ServerSocketWrapper(port);
    switch (serverType) {
      case echo:
        new EchoServer(socket).start();
      case http:
        new HTTPServer(socket).start();
      default:
        System.out.println("Please provide either 'echo' or 'http' for the second argument");
    }
  }
}

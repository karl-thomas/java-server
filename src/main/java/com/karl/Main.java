package com.karl;

import java.io.IOException;
import com.karl.constants.Globals;
import com.karl.echo.EchoHandlerFactory;
import com.karl.http.HTTPHandlerFactory;
import com.karl.wrappers.ServerSocketable;

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

    ServerSocketable socket = new ServerSocketWrapper(port);
    switch (serverType) {
      case echo:
        ProtocolFactoryable echoFactory = new EchoHandlerFactory();
        new Server(socket, echoFactory).start();
      case http:
        ProtocolFactoryable httpFactory = new HTTPHandlerFactory();
        new Server(socket, httpFactory).start();
      default:
        System.out.println("Please provide either 'echo' or 'http' for the second argument");
    }
  }
}

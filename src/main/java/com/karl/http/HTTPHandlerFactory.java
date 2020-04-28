package com.karl.http;

import com.karl.ProtocolFactoryable;
import com.karl.wrappers.WrappedSocket;

public class HTTPHandlerFactory implements ProtocolFactoryable {
  public Runnable create(WrappedSocket socket) {
    return new HTTPHandler(socket);
  }
}

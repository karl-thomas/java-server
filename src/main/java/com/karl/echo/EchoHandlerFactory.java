package com.karl.echo;

import com.karl.ProtocolFactoryable;
import com.karl.wrappers.WrappedSocket;

public class EchoHandlerFactory implements ProtocolFactoryable {
  public Runnable create(WrappedSocket socket) {
    return new EchoHandler(socket);
  }
}

package com.karl.echo;

import com.karl.ProtocolFactoryable;
import com.karl.wrappers.Connectable;

public class EchoHandlerFactory implements ProtocolFactoryable {
  public Runnable create(Connectable socket) {
    return new EchoHandler(socket);
  }
}

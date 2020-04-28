package com.karl.http;

import com.karl.ProtocolFactoryable;
import com.karl.wrappers.Connectable;

public class HTTPHandlerFactory implements ProtocolFactoryable {
  public Runnable create(Connectable connection) {
    return new HTTPHandler(connection);
  }
}

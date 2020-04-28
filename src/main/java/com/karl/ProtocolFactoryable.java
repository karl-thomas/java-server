package com.karl;

import com.karl.wrappers.WrappedSocket;

public interface ProtocolFactoryable {
  public Runnable create(WrappedSocket socket);
}

package com.karl;

import com.karl.wrappers.Connectable;

public interface ProtocolFactoryable {
  public Runnable create(Connectable connection);
}

package com.karl.mocks;

import com.karl.ProtocolFactoryable;
import com.karl.wrappers.Connectable;

public class MockProtocolFactory implements ProtocolFactoryable {
  public Runnable runner;
  public int createCalled = 0;

  public MockProtocolFactory setRunner(Runnable runner) {
    this.runner = runner;
    return this;
  }

  public Runnable create(Connectable connection) {
    createCalled = createCalled + 1;
    return this.runner;
  }
}

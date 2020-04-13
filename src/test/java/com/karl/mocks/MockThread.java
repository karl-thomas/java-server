package com.karl.mocks;

public class MockThread {
  public Runnable handler;

  public MockThread(Runnable handler) {
    this.handler = handler;
  }

  public void start() {
    this.handler.run();
  }
}

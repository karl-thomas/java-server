package com.karl.mocks;

public class MockRunnable implements Runnable {
  public int runCalled = 0;

  public void run() {
    this.runCalled = runCalled + 1;
  }
}

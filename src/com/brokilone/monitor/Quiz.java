package com.brokilone.monitor;

public class Quiz {
  private static final Object lock = new Object();
  private static final Object lock2 = new Object();

  public static void main(String[] args) throws InterruptedException {

    synchronized (lock) {
      lock2.wait();
    }

  }
}

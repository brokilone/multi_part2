package com.brokilone.monitor;

public class SynchronizedDemo {
  public synchronized void demoMethod() {
  }

  public void demoMethod2() {
    synchronized (this) {
    }
  }

  public synchronized static void staticDemoMethod() {
  }

  public static void staticDemoMethod2() {
    synchronized (SynchronizedDemo.class) {
    }
  }
}

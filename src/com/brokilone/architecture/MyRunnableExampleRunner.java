package com.brokilone.architecture;

public class MyRunnableExampleRunner {
  public static void main(String[] args) {
    Thread thread = new Thread(new MyRunnable());
    thread.start();
  }
}

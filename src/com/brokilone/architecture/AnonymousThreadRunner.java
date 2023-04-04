package com.brokilone.architecture;

public class AnonymousThreadRunner {
  public static void main(String[] args) {
    Thread thread = new Thread() {
      @Override
      public void run() {
        System.out.println("Hello from thread!");
      }
    };
    thread.start();
  }
}

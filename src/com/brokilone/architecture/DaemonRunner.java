package com.brokilone.architecture;

public class DaemonRunner {
  public static void main(String[] args) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          System.out.println("Hello!");
          try {
            Thread.sleep(10);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
    thread.setDaemon(true);
    thread.start();
    System.out.println("Bye from main");

  }
}

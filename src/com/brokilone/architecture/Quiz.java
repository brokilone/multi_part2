package com.brokilone.architecture;

public class Quiz {
  public static void main(String[] args) {
    new XThread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello from Runnable");
      }
    }).start();

  }
}

class XThread extends Thread {

  public XThread(Runnable target) {
    super(target);
  }

  @Override
  public void run() {
    System.out.println("Hello from XThread");
  }
}

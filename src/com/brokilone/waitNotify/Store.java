package com.brokilone.waitNotify;

public class Store {
  private Integer product = null;

  public synchronized void get() {
    while (product == null) {
      System.out.println("wait for put");
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    product = null;
    System.out.println("Покупатель забрал товар");
    notify();
  }

  public synchronized void put() {
    while (product != null) {
      System.out.println("wait for get");
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    product = 1;
    System.out.println("Производитель привез товар");
    notify();
  }
}

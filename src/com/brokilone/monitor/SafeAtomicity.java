package com.brokilone.monitor;

public class SafeAtomicity {
  public static SafePair pair = new SafePair();

  public static void main(String[] args) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          pair.incXY();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println(pair.sum()); //ожидаем 2 или 4
      }
    }).start();
  }
}

class SafePair {
  private int x = 1;
  private int y = 1;

  public synchronized void incXY() throws InterruptedException {
    x++;
    Thread.sleep(500);
    y++;
  }

  public synchronized int sum() {
    return x + y;
  }
}


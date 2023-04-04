package com.brokilone.monitor;

import java.util.concurrent.atomic.AtomicInteger;

public class UnsafeAtomicity {
  public static Pair pair = new Pair();

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

class Pair {
  private AtomicInteger x = new AtomicInteger(1);
  private AtomicInteger y = new AtomicInteger(1);

  public void incXY() throws InterruptedException {
    x.incrementAndGet();
    Thread.sleep(500);
    y.incrementAndGet();
  }

  public int sum() {
    return x.addAndGet(y.intValue());
  }
}


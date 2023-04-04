package com.brokilone.architecture;

public class PriorityRunner {
  public static volatile boolean stop = false;

  public static void main(String[] args) throws InterruptedException {
    final Thread[] threads = new Thread[20];
    for (int i = 0; i < 20; i++) {
      final int threadIdx = i;
      threads[i] = new Thread(new Runnable() {
        @Override
        public void run() {
          for (long idx = 0; idx < 1_000_000_000_000L; idx ++) {
            if (stop) {
              System.out.println("Number: " + threadIdx + ", index: " + idx);
              break;
            }
          }
        }
      });
    }

    for (int i = 0; i < 20; i++) {
      threads[i].setPriority(i < 10 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY);
    }

    for (int i = 0; i < 20; i++) {
      threads[i].start();
    }

    Thread.sleep(10);
    stop = true;
  }
}

package com.brokilone.monitor;

public class ReentrantExample{
  public static void main(String[] args) {
    Reentrant reentrant = new Reentrant();

    new Thread(reentrant::a).start();
  }

}
class Reentrant{
  public synchronized void a() {
    b();
    System.out.println("here I am, in a()");
  }
  public synchronized void b() {
    System.out.println("here I am, in b()");
  }
}

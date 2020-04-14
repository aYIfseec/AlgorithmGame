package misc;

import java.util.concurrent.TimeUnit;

/**
 * @author huangyongkang, created 2020-04-12
 */


public class VolatileTest02 {

  private int count;
//  private volatile boolean running = true;

  private VolatileTest02() {
    count = 0;
  }

  public static void main(String[] args) {
    VolatileTest02 volatileTest = new VolatileTest02();
    new Thread(volatileTest::run).start();
    new Thread(volatileTest::run).start();
    new Thread(volatileTest::run).start();
    new Thread(volatileTest::run).start();
    new Thread(volatileTest::run).start();


    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // 预计值 = 线程数 * 100000
    // 若无 synchronized，则 实际值 <= 预计值
    System.out.println("count is " + volatileTest.count);
  }


//  private void run() {
//    // 循环次数少了难以出现
//    for (int i = 0; i < 100000; i++) {
//      count++;
//    }
//  }


  private void run() {
    synchronized (this) {
      // 循环次数少了难以出现
      for (int i = 0; i < 100000; i++) {
        count++;
      }
    }
  }

}


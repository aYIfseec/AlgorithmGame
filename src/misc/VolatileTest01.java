package misc;

import java.util.concurrent.TimeUnit;

/**
 * @author huangyongkang, created 2020-04-12
 */


public class VolatileTest01 {

  private boolean running = true;
//  private volatile boolean running = true;

  public static void main(String[] args) {
    VolatileTest01 volatileTest = new VolatileTest01();
    new Thread(volatileTest::run).start();


    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    volatileTest.stop();

  }

  private void stop() {
    running = false;
    System.out.println("running = false");
  }


  private void run() {
    while (running) {
      // 若这里面有逻辑，则难以重现一直running问题
//      System.out.println(Thread.currentThread().getName() + " is running");
    }
    System.out.println(Thread.currentThread().getName() + " is stop");
  }

}


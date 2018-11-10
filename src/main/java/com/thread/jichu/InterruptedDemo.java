package com.thread.jichu;

import static java.lang.Thread.sleep;

/**
 * Created by 张强强 on 2018/11/10.
 */
public class InterruptedDemo {

      public static class TestInterruptRunnable implements Runnable{
          @Override
          public void run() {
              boolean interrupted = Thread.currentThread().isInterrupted();
              System.out.println("20行"+interrupted);  //false
              try {
                  sleep(5000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
             //     Thread.currentThread().interrupt();
              }
              System.out.println("26行"+interrupted);      //false
          }
      }

    public static void main(String[] args) throws InterruptedException {
        TestInterruptRunnable testInterruptRunnable = new TestInterruptRunnable();
        Thread t = new Thread(testInterruptRunnable);
        t.start();
        sleep(1000);
        t.interrupt();
        System.out.println("36行"+t.isInterrupted());     //时而true  时而false
        /**
         * 如果36行执行在26行或异常之前则为true  在后则为false
         * 可以得出 InterruptedException 会把 isInterrupted 置为false
         * 避免的方法可以在catch中在调运一次interrupt()  如19行
         */
    }
}

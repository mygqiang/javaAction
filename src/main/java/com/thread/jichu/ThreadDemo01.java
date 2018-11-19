package com.thread.jichu;

import java.time.LocalTime;

/**
 * Created by 张强强 on 2018/11/10.
 */
public class ThreadDemo01 {

    public static class ExThread extends Thread{

        @Override
        public synchronized   void run(){
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("异步"+ LocalTime.now());
        }
    }

    public static void main(String[] args) {
        ExThread et =  new ExThread();

        et.start();
      Thread t = new Thread(et);
      Thread t2 = new Thread(et);
      t.start();
      t2.start();
        System.out.println("我能先行一步吗");
       /* System.out.println( Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println( Thread.currentThread().isInterrupted());
       Thread.interrupted();
        System.out.println( Thread.currentThread().isInterrupted());*/

    }
}

/**
 我能先行一步吗
 异步13:19:41.490
 异步13:19:46.492
 异步13:19:51.493

    三个线程是同一个对象锁
 **/
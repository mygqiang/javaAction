package com.thread.jichu;

/**
 * Created by 张强强 on 2018/11/10.
 */
public class ThreadDemo01 {

    public static class ExThread extends Thread{

        @Override
        public void run(){
            try {
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("异步");
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
    }
}

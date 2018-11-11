package com.thread.jichu;

import static java.lang.Thread.sleep;

/**
 * Created by 张强强 on 2018/11/11.
 */
public class GuardThread {

    public static class Demno extends Thread{
        int i = 0;
        @Override
        public void run(){
            try {
                while (true){
                    System.out.println("我要做主线程的守护线程"+i);
                    i++;
                }
            }finally {
                System.out.println("猜猜我会执行吗?");  //没有打印这句话
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread demno = new Demno();
        demno.setDaemon(true);  //必须在start方法之前
        demno.start();
    //    demno.setDaemon(true);  //在start方法之后没有做用
        sleep(10);
    }
}


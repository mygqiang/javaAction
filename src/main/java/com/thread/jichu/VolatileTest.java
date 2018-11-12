package com.thread.jichu;

import static java.lang.Thread.sleep;

/**
 * Created by 张强强 on 2018/11/11.
 */
public class VolatileTest {

    public static class  NoLock extends Thread{
        public boolean flage = true;
        int i=0;
        @Override
        public  void run(){
            while (flage){
           //     i++;
                i=i+6+9-5-6-3;
            }
        }
    }
    public static class  SyLock extends Thread{
        public Boolean flage = true;
        int i=0;
        @Override
        public  void run(){

            while (flage){
                synchronized(this){
                    i=i+6+9-5-6-3;
                }
                // System.out.println(false);
            }
        }
    }
 public static class  VolatileDemo extends Thread{
        public volatile Boolean flage = true;
        int i=0;
        @Override
        public  void run(){
            while (flage){
                synchronized(this){
                    i=i+6+9-5-6-3;
                }
                // System.out.println(false);
            }
        }
    }



    public static void main(String[] args) throws InterruptedException {
     /*  NoLock noLock = new NoLock();
        noLock.start();
        sleep(10);
        noLock.flage=false;
        sleep(10);
        System.out.println(noLock.flage);
      //  程序不会停止*/
/*

       SyLock syLock = new SyLock();
        syLock.start();
        sleep(10);
        syLock.flage=false;
        sleep(10);
        System.out.println(syLock.flage);
          //程序会停止
*/

        VolatileDemo volatileDemo = new VolatileDemo();
        volatileDemo.start();
        sleep(10);
        volatileDemo.flage=false;
        sleep(10);
        System.out.println(volatileDemo.flage);
        //程序会停止
    }
}

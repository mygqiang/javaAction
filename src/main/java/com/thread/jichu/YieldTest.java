package com.thread.jichu;

/**
 * Created by 张强强 on 2018/11/19.
 */
public class YieldTest {
    public static  class Yieldtest1 extends Thread{
        @Override
        public  void run(){
            for (int i=0; i<1000; i++){

                yield();
                System.out.println(Thread.currentThread().getName()+"="+i);
            }
        }
    }

    public static void main(String[] args) {
        Yieldtest1 yieldtest1 = new Yieldtest1();
       /* Yieldtest1 yieldtest2 = new Yieldtest1();
        Yieldtest1 yieldtest3 = new Yieldtest1();*/

        Thread t2 = new Thread(yieldtest1,"iiiiiiiii");
        Thread t3 = new Thread(yieldtest1,"eeeeeeeeeeeeeee");
        Thread t4 = new Thread(yieldtest1,"rrrr");
        t2.start();
        t3.start();
        t4.start();
    }

}

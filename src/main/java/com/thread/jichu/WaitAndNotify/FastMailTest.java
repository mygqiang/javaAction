package com.thread.jichu.WaitAndNotify;

import static java.lang.Thread.sleep;

/**
 * Created by 张强强 on 2018/11/12.
 */
public class FastMailTest {
   static FastMail fm = new FastMail();
    public static class Test extends Thread{
        @Override
        public void run(){
                fm.collectGoodsByAddr();
        }
    }

    public static class Test2 extends Thread{
        @Override
        public void run(){
                fm.collectGoodsBychangeDistance();
        }
    }
    public static void main(String[] args) throws InterruptedException {

        Test test1 = new Test();
        Test2 test2 = new Test2();
        test1.start();
        test2.start();
        sleep(50);
        fm.changeDistance();

    }
}


/*
 notify()
 373737
4646464
373737
* */

/*
 notifyAll()
 373737
4646464
快到收货点了,准备收货!
373737
* */
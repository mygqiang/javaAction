package com.thread.jichu;

/**
 * Created by 张强强 on 2018/11/19.
 */
public class JoinDemo {

    public static  class Jpintest1 extends Thread{
        @Override
        public void run(){
            for (int i=0; i<10; i++){
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("++++++++++++++"+i);
            }
        }
    }

    public static  class Jpintest2 extends Thread{
        private Thread jpintest1;

        public  Jpintest2(Thread jpintest1){
         //   System.out.println("fr"+jpintest1);
            this.jpintest1 = jpintest1;
        }

        @Override
        public void run(){
            for (int i=0; i<10; i++){
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i==5){
                    try {
                        System.out.println("-----------"+jpintest1);
                        jpintest1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("---------"+i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Jpintest1 jpintest1 = new Jpintest1();
        Thread t1 = new Thread(jpintest1);
        t1.start();

        Jpintest2 jpintest2 = new Jpintest2(t1);   //这里传入jpintest1不会报错但是join方法调运没有效果
        Thread t2 = new Thread(jpintest2);
        t2.start();

    }
}

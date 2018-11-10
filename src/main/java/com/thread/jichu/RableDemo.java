package com.thread.jichu;

import static java.lang.Thread.sleep;

/**
 * Created by 张强强 on 2018/11/10.
 */
public class RableDemo {

    public static class ImRable implements Runnable{

        @Override
        public void run() {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2秒之后我会出现");
        }
    }

    public static void main(String[] args) {
        ImRable imRable = new ImRable();
        Thread thread = new Thread(imRable);
        thread.start();
        System.out.println("我先一步了");
    }
}

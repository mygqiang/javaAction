package com.thread.jichu;

/**
 * Created by 张强强 on 2018/11/12.
 */
public class ThreadLocalTest {

      static   ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
      @Override
      protected Integer  initialValue(){
            return 1;
        }
    };

    public static class ThreadTest implements Runnable{
        @Override
        public synchronized void run(){
            Integer integer = threadLocal.get();
            System.out.println("没有自增之前"+integer);
            threadLocal.set(++integer);
            System.out.println("自增之后"+threadLocal.get());

        }
    }

    public void startThread(){
        Thread [] run = new Thread[3];
        for (int i=0; i<run.length; i++){
          run[i] = new Thread(new ThreadTest());
        }

        for(int i=0; i<run.length; i++){
            run[i].start();
        }
    }

    public static void main(String[] args) {
        ThreadLocalTest tt = new ThreadLocalTest();
        tt.startThread();
    }

    /**
     * 没有自增之前1
     没有自增之前1
     自增之后2
     自增之后2
     没有自增之前1
     自增之后2
     */
}

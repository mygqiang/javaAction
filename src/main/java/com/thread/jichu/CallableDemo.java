package com.thread.jichu;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

/**
 * Created by 张强强 on 2018/11/10.
 */
public class CallableDemo {

    public static class ImCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            sleep(2000);
            System.out.println("我不但有返回值,我还能抛出Exception异常");
            return "我的使用比较复杂,是多线程中的Future模式";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ImCallable imCallable = new ImCallable();
        FutureTask<String>  ft =  new FutureTask<String>(imCallable);
        Thread t = new Thread(ft);
     //   System.out.println(ft.get());     //这个注解打开线程将会堵死在这,因为没有启动线程先调了get方法(这个方法是阻塞的)
        t.start();
        System.out.println(ft.get());
    }

}
/**
 我不但有返回值,我还能抛出Exception异常
 我的使用比较复杂,是多线程中的Future模式
 */
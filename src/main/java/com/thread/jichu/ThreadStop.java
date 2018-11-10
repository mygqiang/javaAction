package com.thread.jichu;

import static java.lang.Thread.sleep;

/**
 * Created by 张强强 on 2018/11/10.
 * stop 方法是立即调运立即停止,比较暴力
 * interrupted 是在主线程中给线程打一个停止的标记,线程中可以获取到这个标记的状态来对线程进行处理,可以更好的体现线程之间的协作性
 */
public class ThreadStop {
   // stop()，resume(),suspend()已不建议使用，stop()会导致线程不会正确释放资源，suspend()容易导致死锁。
    public static  class Stop extends Thread{
        int i = 0;
        @Override
        public  void run(){
            while (true){
                System.out.println(this.getName()+i);
                i++;
            }
        }
   }

   public static  class Interrupted extends Thread{
        @Override
        public void run(){
            while (!isInterrupted()){
                System.out.println("守住阵地等待集结号!");
            }
            System.out.println("我没有吹号");
        }
   }

    public static void main(String[] args) throws InterruptedException {
        Stop s = new Stop();
        s.setName("ss");
        s.start();
        sleep(200);
        s.stop();

        Interrupted interrupted = new Interrupted();
        interrupted.start();
        sleep(200);
        interrupted.interrupt();
    }
}

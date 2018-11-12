package com.thread.jichu.WaitAndNotify;

/**
 * Created by 张强强 on 2018/11/12.
 */
public class FastMail {

    /**
     * 发货地址
     */
    private    String  addr = "门头沟";

    /**
     * 发货货距离
     */
    private  int distance = 100000;

    /**
     * 通知到达收货地点
     */
    public synchronized void changeAddr(){
        addr = "康家沟";
     //   notify();
        notifyAll();
    }

    /**
     * 通知快到收货地方
     */
    public synchronized  void changeDistance(){
        distance = 100;
     //  notify();
        notifyAll();
    }

    public synchronized void collectGoodsByAddr()  {
        while (!addr.equals("康家沟")){
            System.out.println("373737");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("收货了");
    }

    public synchronized  void collectGoodsBychangeDistance() {
        while (distance>1000){
            System.out.println(4646464);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("快到收货点了,准备收货!");
    }
}

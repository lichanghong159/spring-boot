package com.lch.spring.boot.springbootredis.demo;

import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * <p>事务示例</p>
 *
 * @author lichanghong     create by   2018/9/14 15:22
 **/
public class TransactionDemo {
    private static final String host = "192.168.170.80";//连接地址
    static  final Jedis jedis = new Jedis(host);//客户端
    static String key ="trans";
    public static void noTrans()  {
        Jedis conn = new Jedis(host);
        System.out.println(conn.incr(key));
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conn.incrBy(key,-1);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<3;i++){
            new Thread(()->noTrans()).start();
        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(jedis.get(key));
    }
}

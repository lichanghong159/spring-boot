package com.lch.spring.boot.springbootredis.demo;

import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * <p>redis发布与订阅</p>
 *
 * @author lichanghong     create by   2018/9/14 13:38
 **/
public class PublishDemo {
    private static final String host = "192.168.170.80";//连接地址
    static  final Jedis jedis = new Jedis(host);//客户端
     static final  String CHANNEL="Listener";//发布订阅的频道
    public static void main(String[] args) throws InterruptedException {
        publish();
    }
    public static  void publish() throws InterruptedException {
        for (int i=1;i<1000;i++ ){
            jedis.publish(CHANNEL, "data->"+i);
            TimeUnit.MICROSECONDS.sleep(50);
        }
    }

}
package com.lch.spring.boot.springbootredis.demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * <p></p>
 *
 * @author lichanghong     create by   2018/9/14 14:32
 **/
public class SubscribeDemo {
    private static final String host = "192.168.170.80";//连接地址
    static  final Jedis jedis = new Jedis(host);//客户端
    static final  String CHANNEL="Listener";//发布订阅的频道

    public static void main(String[] args) {
        jedis.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                super.onMessage(channel, message);
                System.out.printf("SubscribeDemo channel->%s ,message->%s\n",channel,message);
            }
        }, CHANNEL);
        jedis.unwatch();
    }

}

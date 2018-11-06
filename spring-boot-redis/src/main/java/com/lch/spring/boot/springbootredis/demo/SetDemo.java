package com.lch.spring.boot.springbootredis.demo;

import redis.clients.jedis.Jedis;

/**
 * <p>学习redis对结合的操作</p>
 *
 * @author lichanghong     create by   2018/9/14 11:03
 **/
public class SetDemo {
    private static final String host = "192.168.170.80";//连接地址
    static  final Jedis jedis = new Jedis(host);//客户端
    static  final String KEY="set-key";//缓存key
    public static void main(String[] args) {
        //查询指定集合中所有的元素
        System.out.println(jedis.smembers(KEY));
        //将"set-key"集合中的a元素移动到"set-key1"集合中
        jedis.smove(KEY, KEY+1, "a");
    }

    /**
     * 查询元素数量
     */
    private static void count() {
        long count =jedis.scard(KEY);
        System.out.println(count);
    }

    //添加
    private static void sadd() {
        long result=jedis.sadd(KEY,"a","b");
        result= jedis.sadd(KEY,"d");
        System.out.println(result);
    }
}

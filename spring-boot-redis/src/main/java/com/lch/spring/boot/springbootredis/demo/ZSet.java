package com.lch.spring.boot.springbootredis.demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * <p>有序集合</p>
 *
 * @author lichanghong     create by   2018/9/14 11:51
 **/
public class ZSet {
    private static final String host = "192.168.170.80";//连接地址
    static  final Jedis jedis = new Jedis(host);//客户端
    static  final String KEY="zset-key";//缓存key
    static Map<String, Double> scoreMembers =new HashMap<>();
    static {
        for (double i =0;i<10;i++){
            scoreMembers.put("key"+i, i);
        }
    }
    public static void main(String[] args) {
        //获取指定Score范围之内的数据，
        Set<Tuple> set = jedis.zrangeByScoreWithScores(KEY, 0, -1);
        set.forEach(tuple -> {
            System.out.println(tuple.getElement()+"\t"+tuple.getScore());
        });

    }

    private static void remove() {
        jedis.zrem(KEY,"key0.0");
    }

    private static void zincrby() {
        Double result = jedis.zscore(KEY, "a");
        System.out.println(result);
        //对集合中指定的元素进行自增操作
        result= jedis.zincrby(KEY, 5, "a");
        System.out.println(result);
    }

    private static void count() {
        //查询集合中元素的数量
        long result=  jedis.zcard(KEY);
        System.out.println(result);
    }

    private static void zadd() {
        //添加单个
        // jedis.zadd(KEY, 5D, "a");
        //将map添加到指定的有序集合中
        long result=  jedis.zadd(KEY, scoreMembers);
        System.out.println(result);
    }
}

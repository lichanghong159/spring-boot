package com.lch.spring.boot.springbootredis.cluster;

import redis.clients.jedis.*;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <p>集群示例代码</p>
 *
 * @author lichanghong     create by   2018/9/27 11:51
 **/
public class RedisClusterDemo {
    public static void main(String[] args) {
        cluster();
    }

    private static void cluster() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxTotal(100);
        // 最大空闲数
        poolConfig.setMaxIdle(10);
        // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
        // Could not get a resource from the pool
        poolConfig.setMaxWaitMillis(10000);
        Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
        nodes.add(new HostAndPort("192.168.170.80", 7000));
        nodes.add(new HostAndPort("192.168.170.80", 7001));
        nodes.add(new HostAndPort("192.168.170.80", 7002));
        nodes.add(new HostAndPort("192.168.170.80", 7003));
        nodes.add(new HostAndPort("192.168.170.80", 7004));
        nodes.add(new HostAndPort("192.168.170.80", 7005));
        nodes.add(new HostAndPort("192.168.170.80", 7006));
        nodes.add(new HostAndPort("192.168.170.80", 7007));
        nodes.add(new HostAndPort("192.168.170.80", 7008));
        JedisCluster cluster = new JedisCluster(nodes, poolConfig);
        String name = cluster.get("name");
        System.out.println(name);
        cluster.set("age", "18");
        System.out.println(cluster.get("age"));
        try {
            cluster.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void single(){
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxTotal(2);
        // 最大空闲数
        poolConfig.setMaxIdle(2);
        // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
        // Could not get a resource from the pool
        poolConfig.setMaxWaitMillis(1000);
        JedisPool pool = new JedisPool(poolConfig, "192.168.170.80", 7000 );
        Jedis jedis = null;
        try {
            for (int i = 0; i < 5; i++) {
                jedis = pool.getResource();
                jedis.set("foo" + i, "bar" + i);
                System.out.println("第" + (i + 1) + "个连接, 得到的值为" + jedis.get("foo" + i));
                // 用完一定要释放连接
                jedis.close();
            }
        } finally {
            pool.close();
        }
    }
}

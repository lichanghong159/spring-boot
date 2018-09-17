package com.lch.spring.boot.springbootredis.demo;

import redis.clients.jedis.Client;
import redis.clients.jedis.JedisPubSub;

public class RedisMsgPubSubListener extends JedisPubSub {
    public RedisMsgPubSubListener() {
        super();
    }

    @Override
    public void onMessage(String channel, String message) {
        super.onMessage(channel, message);
        System.out.printf("onMessage->channel:%s,message%s\n", channel, message);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        super.onPMessage(pattern, channel, message);
        System.out.printf("onPMessage->pattern:%s,channel:%s,message%s\n", pattern, channel, message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        super.onSubscribe(channel, subscribedChannels);
        System.out.printf("onSubscribe->channel:%s,subscribedChannels:%s\n", channel, subscribedChannels);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        super.onUnsubscribe(channel, subscribedChannels);
        System.out.printf("onUnsubscribe->channel:%s,subscribedChannels:%s\n", channel, subscribedChannels);
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        super.onPUnsubscribe(pattern, subscribedChannels);
        System.out.printf("onPUnsubscribe->pattern:%s,subscribedChannels:%s\n", pattern, subscribedChannels);
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        super.onPSubscribe(pattern, subscribedChannels);
        System.out.printf("onPSubscribe->pattern:%s,subscribedChannels:%s\n", pattern, subscribedChannels);
    }

    @Override
    public void onPong(String pattern) {
        super.onPong(pattern);
        System.out.printf("onPong->pattern:%s\n", pattern);
    }

    @Override
    public void unsubscribe() {
        super.unsubscribe();
        System.out.printf("unsubscribe\n");
    }

    @Override
    public void unsubscribe(String... channels) {
        super.unsubscribe(channels);
        System.out.printf("unsubscribe->channels:%s\n", channels);
    }

    @Override
    public void subscribe(String... channels) {
        super.subscribe(channels);
        System.out.printf("subscribe->channels:%s\n", channels);
    }

    @Override
    public void psubscribe(String... patterns) {
        super.psubscribe(patterns);
        System.out.printf("psubscribe->patterns:%s\n", patterns);
    }

    @Override
    public void punsubscribe() {
        super.punsubscribe();
        System.out.printf("punsubscribe\n");
    }

    @Override
    public void punsubscribe(String... patterns) {
        super.punsubscribe(patterns);
        System.out.printf("punsubscribe->patterns:%s\n", patterns);
    }

    @Override
    public void ping() {
        super.ping();
        System.out.printf("ping");
    }

    @Override
    public boolean isSubscribed() {
        System.out.printf("isSubscribed\n");
        return super.isSubscribed();

    }

    @Override
    public void proceedWithPatterns(Client client, String... patterns) {
        super.proceedWithPatterns(client, patterns);
        System.out.printf("proceedWithPatterns->client:%s,patterns:%s\n", client, patterns);
    }

    @Override
    public void proceed(Client client, String... channels) {
        super.proceed(client, channels);
        System.out.printf("proceed->client:%s,channels:%s\n", client, channels);

    }

    @Override
    public int getSubscribedChannels() {
        System.out.println("getSubscribedChannels\n");
        return super.getSubscribedChannels();

    }
}
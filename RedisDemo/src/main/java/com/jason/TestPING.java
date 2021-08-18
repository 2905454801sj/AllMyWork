package com.jason;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestPING {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.17.128",6379);
        Transaction transaction = jedis.multi();
        System.out.println(transaction.sadd("111", "111", "222"));
        System.out.println(transaction.set("123123123", "123"));
        System.out.println(transaction.set("1", "2"));
        System.out.println(transaction.get("1"));
        System.out.println(transaction.exec());
        System.out.println(jedis.ping());
    }
}

package com.example.acount.Test;

import redis.clients.jedis.Jedis;

public class redisTest {

public static void main(String[] args) {
    System.out.println("这是一个测试");
    Jedis jedis =new Jedis("localhost",6379);
    jedis.set("testkey2","value2");
    String string =jedis.get("testkey2");
    System.out.print(string);
    jedis.close();

    }

}

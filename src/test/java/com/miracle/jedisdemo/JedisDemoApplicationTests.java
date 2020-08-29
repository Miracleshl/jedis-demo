package com.miracle.jedisdemo;

import com.miracle.jedisdemo.config.JedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
class JedisDemoApplicationTests {

    @Autowired
    private JedisPool jedisPool;

    @Test
    void contextLoads() {
        System.out.println("hello World jedis");
    }

    @Test
    void testJedis(){
        Jedis jedis = new Jedis("192.168.137.128",6379);
        jedis.set("mytest","hello world , this is jedis client!");
        String result = jedis.get("mytest");
        System.out.println(result);
        jedis.close();
    }

    @Test
    void testJedisPool(){
        JedisPool jedisPool = new JedisPool("192.168.137.128",6379);
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get("mytest");
        System.out.println(result);
        jedis.close();
        jedisPool.close();
    }

    @Test
    void testSpringJedisPool(){
        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.get("mytest"));
        Set<Tuple> selltop =jedis.zrangeWithScores("selltop",0 ,-1);
        System.out.println(selltop);
        Transaction transaction = jedis.multi();

        jedis.close();
        jedisPool.close();
    }

    @Test
    void testArrayList(){
        ArrayList list = new ArrayList(10);
        list.add(1);
        System.out.println(list.size());
        Object[] objects = new Object[3];
    }

}

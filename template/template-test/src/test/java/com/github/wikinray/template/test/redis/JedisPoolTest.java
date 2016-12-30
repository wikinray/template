package com.github.wikinray.template.test.redis;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by w on 2016/12/29.
 */
@ContextConfiguration("classpath:spring/template-bean.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JedisPoolTest extends TestCase{
    @Autowired
    private JedisPool jedisPool;

    @Test
    public void testJedisPool(){
        Jedis jedis=jedisPool.getResource();
        jedis.set("abc", "helloworld");
        System.out.println(jedis.get("abc"));
        jedis.del("abc");
        System.out.println(jedis.get("abc"));
    }
}

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
 * Created by w on 2016/12/23.
 */
@ContextConfiguration("classpath:spring/template-bean.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JedisTest extends TestCase{

   /* private static String host = "192.168.109.139";
    private static String port = "6379";
    private Jedis jedis;
    private JedisPool jedisPool;

    @Before
    public synchronized void connect(){
        this.jedis =new Jedis(host,Integer.valueOf(port));
        this.jedisPool=new JedisPool(host,Integer.valueOf(port));
    }

    @After
    public synchronized void close(){
        jedis.close();
    }

    @Test
    public void testJedisSingle(){
        jedis.set("abc", "helloworld");
        System.out.println(jedis.get("abc"));
        jedis.del("abc");
        System.out.println(jedis.get("abc"));
    }

    @Test
    public void testJedisPool(){
        jedis=jedisPool.getResource();
        jedis.set("abc", "helloworld");
        System.out.println(jedis.get("abc"));
        jedis.del("abc");
        System.out.println(jedis.get("abc"));
    }*/

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

package com.github.wikinray.template.test.redis;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by w on 2016/12/29.
 */
@ContextConfiguration("classpath:spring/template-bean.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JedisClusterTest extends TestCase{

    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void basicOpTestForCluster(){
        long begin = System.currentTimeMillis();
        for(int i=0;i<10000; i++){
            jedisCluster.set("person." + i + ".name", "frank");
            jedisCluster.set("person." + i + ".city", "beijing");
            String name = jedisCluster.get("person." + i + ".name");
            String city = jedisCluster.get("person." + i + ".city");
            System.out.println(i + ":" + name + "," + city);
            jedisCluster.del("person." + i + ".name");
            jedisCluster.del("person." + i + ".city");
            Boolean result = jedisCluster.exists("person." + i + ".name");
            Boolean result0 = jedisCluster.exists("person." + i + ".city");
            System.out.println(i+":"+result+","+result0);
        }
        long end = System.currentTimeMillis();
        System.out.println("total time: " + (end-begin)/1000);
    }

    @Test
    public void RedisTest(){
        Set nodes = new HashSet();
        nodes.add(new HostAndPort("192.168.109.141", 7005));
        JedisCluster   js = new JedisCluster(nodes);
        js.set("App", "iphone7");
        System.out.println("客户端测试完毕");
        System.out.println(js.get("App"));

    }
}

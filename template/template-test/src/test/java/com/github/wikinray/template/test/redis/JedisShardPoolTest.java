package com.github.wikinray.template.test.redis;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by w on 2017/1/3.
 */
@ContextConfiguration("classpath:spring/redis/applationContext-shardedJedisPool.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JedisShardPoolTest extends TestCase{

    @Autowired
    private ShardedJedisPool shardedJedisPool;

    @Test
    public void RedisTest(){
        ShardedJedis jedis = shardedJedisPool.getResource();
        long begin = System.currentTimeMillis();
        for(int i=0;i<10000; i++){
            jedis.set("person." + i + ".name", "frank");
            jedis.set("person." + i + ".city", "beijing");
            String name = jedis.get("person." + i + ".name");
            String city = jedis.get("person." + i + ".city");
            System.out.println(i + ":" + name + "," + city);
            jedis.del("person." + i + ".name");
            Boolean result = jedis.exists("person." + i + ".name");
            System.out.println(i + ":name=" + result);
            result = jedis.exists("person." + i + ".city");
            System.out.println(i + ":city=" + result);
        }
        long end = System.currentTimeMillis();
        for(Jedis myJedis: jedis.getAllShards()){
            System.out.println("redis shard: " +
                    myJedis.getClient().getHost() + ":" + myJedis.getClient().getPort());
            System.out.println("redis shard size: " + myJedis.dbSize());
        }
        System.out.println("total time: " + (end-begin)/1000);
        jedis.close();
    }

    @Test
    public void RedisTestGet(){
        ShardedJedis jedis = shardedJedisPool.getResource();
        System.out.println(jedis.set("person.3629.city","HK"));
        System.out.println(jedis.get("person.3629.city"));
    }

}

package com.github.wikinray.template.Registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.JedisCluster;

import java.io.*;

/**
 * Created by w on 2017/1/4.
 */
public class RedisSessionRegistry implements SessionRegistry {

    @Autowired
    private JedisCluster jedisCluster;
    @Value(value="1000")
    private int timeout;

    @Override
    public void setSession(String id, String name, Object object) {
        ObjectOutputStream oos=null;
        try {
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            oos=new ObjectOutputStream(bos);
            oos.writeObject(object);
            jedisCluster.hset(id.getBytes(), name.getBytes(), bos.toByteArray());
            refresh(id);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(null!=oos)
                    oos.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getSession(String id, String name) {
        String str=null;
        byte[] value =jedisCluster.hget(id.getBytes(),name.getBytes());
        if(null!=value){
            try {
                ByteArrayInputStream bais=  new ByteArrayInputStream(value);
                ObjectInputStream ois=new ObjectInputStream(bais);
                str=(String)ois.readObject();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return str;
    }

    @Override
    public boolean isValid(String id) {
        boolean result=false;
        if(jedisCluster.exists(id.getBytes()))
            result=true;
        return result;
    }

    @Override
    public void refresh(String id) {
        jedisCluster.expire(id.getBytes(),timeout);
    }

    @Override
    public void destroy(String id) {
        jedisCluster.del(id.getBytes());
    }
}

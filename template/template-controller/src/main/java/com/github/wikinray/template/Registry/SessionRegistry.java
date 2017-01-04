package com.github.wikinray.template.Registry;

/**
 * Created by w on 2017/1/4.
 */
public interface SessionRegistry {

    void setSession(String id,String name,Object object);

    String getSession(String id,String name);

    boolean isValid(String id);

    void refresh(String id);

    void destroy(String id);
}

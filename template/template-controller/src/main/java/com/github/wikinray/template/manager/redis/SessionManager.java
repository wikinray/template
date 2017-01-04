package com.github.wikinray.template.manager.redis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by w on 2017/1/4.
 */
public interface SessionManager {

    final static String SESSION_ID="TOKEN";

    void setSession(String name,Object value,HttpServletRequest request,HttpServletResponse response);

    Object getSession(String name,Object value,HttpServletRequest request);

    void destroySession(HttpServletRequest request,HttpServletResponse response);
}

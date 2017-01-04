package com.github.wikinray.template.manager.impl.redis;

import com.github.wikinray.template.Registry.SessionRegistry;
import com.github.wikinray.template.manager.redis.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by w on 2017/1/4.
 */
public class SessionManagerImpl implements SessionManager {

    @Autowired
    private SessionRegistry sessionRegistry;

    @Override
    public void setSession(String name, Object value, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies=request.getCookies();
        if(null!=cookies){
            for (Cookie cookie:cookies){
                if(cookie.getName().equals(SESSION_ID)){
                    if(sessionRegistry.isValid(cookie.getValue())){
                        sessionRegistry.setSession(cookie.getValue(),name,value);
                        return;
                    }
                }
            }
        }
        String sessionId = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        sessionRegistry.setSession(sessionId, name, value);
        Cookie newCookie = new Cookie(SESSION_ID,sessionId);
        response.addCookie(newCookie);
    }


    @Override
    public Object getSession(String name, Object value, HttpServletRequest request) {
        Cookie[] cookies=request.getCookies();
        if(null!=cookies){
            for (Cookie cookie:cookies){
                if(cookie.getName().equals(SESSION_ID)){
                    return sessionRegistry.getSession(cookie.getValue(), name);
                }
            }
        }
        return null;
    }


    @Override
    public void destroySession(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies=request.getCookies();
        if(null!=cookies){
            for (Cookie cookie:cookies){
                if(cookie.getName().equals(SESSION_ID)){
                    sessionRegistry.destroy(cookie.getValue());
                    response.addCookie(cookie);
                    return;
                }
            }
        }
    }
}

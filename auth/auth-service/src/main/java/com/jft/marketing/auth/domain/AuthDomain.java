package com.jft.marketing.auth.domain;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.jft.marketing.request.UserInfoReq;
import com.jft.marketing.service.IUserInfoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;

@Component
public class AuthDomain {

    @DubboReference(version = "1.0.0")
    private IUserInfoService userInfoService;

    public String test(String id){
        UserInfoReq req=userInfoService.sayHello(id);
        return JSONObject.toJSONString(req);
    }
}

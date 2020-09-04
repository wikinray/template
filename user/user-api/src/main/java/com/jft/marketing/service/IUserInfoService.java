package com.jft.marketing.service;

import com.jft.marketing.request.UserInfoReq;
import io.swagger.annotations.Api;

@Api(tags="测试")
public interface IUserInfoService {

    UserInfoReq sayHello(String id);
}

package com.jft.marketing.service.imp;

import com.jft.marketing.dao.po.UserInfo;
import com.jft.marketing.domain.UserInfoDomain;
import com.jft.marketing.request.UserInfoReq;
import com.jft.marketing.service.IUserInfoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DubboService(version = "1.0.0")
@Service
public class UserInfoService implements IUserInfoService {
    @Override
    public UserInfoReq sayHello(String id) {
        UserInfo userInfo= userInfoDomain.getById(id);
        UserInfoReq req=new UserInfoReq();
        BeanUtils.copyProperties(userInfo,req);
        return req;
    }



    @Autowired
    private UserInfoDomain userInfoDomain;

    public UserInfo getById(String id){
        return userInfoDomain.getById(id);
    }
}

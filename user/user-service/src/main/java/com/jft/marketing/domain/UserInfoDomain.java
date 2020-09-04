package com.jft.marketing.domain;

import com.jft.marketing.dao.mapper.UserInfoMapper;
import com.jft.marketing.dao.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoDomain {

    @Autowired
    private UserInfoMapper userInfoMapper;


    public UserInfo getById(String id){
        UserInfo userInfo=userInfoMapper.selectByPrimaryKey(id);
        return userInfo;
    }
}

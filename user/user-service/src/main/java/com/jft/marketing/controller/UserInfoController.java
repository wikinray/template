package com.jft.marketing.controller;

import com.jft.marketing.dao.po.UserInfo;
import com.jft.marketing.service.IUserInfoService;
import com.jft.marketing.service.imp.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserInfoController {


    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "/getById/{id}")
    public UserInfo testHello(@PathVariable String id){
        return userInfoService.getById(id);
    }
}

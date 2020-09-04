package com.jft.marketing.service.imp;

import com.jft.marketing.service.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0")
public class HelloServiceImp implements HelloService {
    @Override
    public String sayHello() {
        return "dubbo sayHello";
    }
}

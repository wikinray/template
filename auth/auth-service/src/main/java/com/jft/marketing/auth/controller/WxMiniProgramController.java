package com.jft.marketing.auth.controller;

import com.jft.marketing.auth.domain.AuthDomain;
import com.jft.marketing.common.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activityMini")
@Slf4j
public class WxMiniProgramController {

    /*@ApiOperation(value = "小程序授权" , notes = "小程序授权" )
    @RequestMapping( value = "/mini/auth" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<String> authGetCode(@RequestBody @Validated WechatAuthReq wechatAuthReq){
        log.info("小程序授权 接口上送:{}", JSONObject.toJSON(wechatAuthReq));
        String code = wechatAuthReq.getCode();
        UserInfo userInfo =  wxMiniService.auth( code);
        String userCode = userInfo.getId();
        log.info("小程序授权 接口返回：userCodeToken{},code={}",JSONObject.toJSONString(userCode),wechatAuthReq.getCode());
        return Result.success( JwtUtil.generateToken( userCode ) );
    }*/


    @Autowired
    private AuthDomain authDomain;

    @GetMapping("/test/{id}")
    public Object test(@PathVariable String id){
        return authDomain.test(id);
    }
}

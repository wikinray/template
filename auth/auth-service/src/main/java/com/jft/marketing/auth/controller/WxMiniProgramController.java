package com.jft.marketing.auth.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activityMini")
public class WxMiniProgramController {

    @ApiOperation(value = "小程序授权" , notes = "小程序授权" )
    @RequestMapping( value = "/mini/auth" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result<String> authGetCode(@RequestBody @Validated WechatAuthReq wechatAuthReq){
        log.info("小程序授权 接口上送:{}", JSONObject.toJSON(wechatAuthReq));
        String code = wechatAuthReq.getCode();
        UserInfo userInfo =  wxMiniService.auth( code);
        String userCode = userInfo.getId();
        log.info("小程序授权 接口返回：userCodeToken{},code={}",JSONObject.toJSONString(userCode),wechatAuthReq.getCode());
        return Result.success( JwtUtil.generateToken( userCode ) );
    }
}

package com.jft.marketing.common.exception;

import lombok.Getter;

@Getter
public enum ActivityMinErrorCode {

    SUCCESS(10000, "成功"),
    PARAM_ERROR(10400, "参数错误"),
    HTTPMEDIATYPENOTSUPPORTED(10401, "请求类型不支持"),
    SERVICE_ERROR(10500, "服务错误"),


    SYSTEM_BUSY(99998, "系统繁忙，请稍后重试"),
    FAIL(99999, "业务失败"),
    NO_PERMISSION(99904, "无权限"),

    ;

    private int value;
    private String message;

    ActivityMinErrorCode(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public static ActivityMinErrorCode getUserErrorCode(int code){
        for(ActivityMinErrorCode obj : ActivityMinErrorCode.class.getEnumConstants()){
            if( obj.getValue() ==  code  ){
                return obj ;
            }
        }
        return null ;
    }
}

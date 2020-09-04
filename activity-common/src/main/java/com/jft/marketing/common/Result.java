package com.jft.marketing.common;


import com.jft.marketing.common.exception.ActivityMinErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "Result", description = "返回结果信息")
public class Result<D> implements Serializable {

    /**
     * code码
     */
    @ApiModelProperty(value = "code码", dataType = "int")
    private int code;
    /**
     * code码中文说明
     */
    @ApiModelProperty(value = "code码中文说明", dataType = "String")
    private String msg;
    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据")
    private D data;

    public static Result success() {
        ActivityMinErrorCode success = ActivityMinErrorCode.SUCCESS;
        return new Result<>(success.getValue(),success.getMessage(),null,"","","","");
    }

    public static <D> Result success(D data) {
        ActivityMinErrorCode success = ActivityMinErrorCode.SUCCESS;
        return new Result<D>(success.getValue(),success.getMessage(),data,"","","","");
    }

    public static <D> Result exception(Exception e) {
        e.printStackTrace();
        return new Result<>(ActivityMinErrorCode.SERVICE_ERROR.getValue(),e.getMessage(),null,"","","","");
    }

    public static <D> Result exception(ActivityMinErrorCode code, String message , D data) {
        return new Result<>(code.getValue(),message,data,"","","","");
    }

    public static <D> Result exception(ActivityMinErrorCode code , D data) {
        return new Result<>(code.getValue(),code.getMessage(),data,"","","","");
    }

    public boolean isSuccess() {
        return this.code == ActivityMinErrorCode.SUCCESS.getValue();
    }

    public Result(){}
    public Result(int code, String msg, D data, String addQx, String delQx, String editQx, String queryQx) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

}


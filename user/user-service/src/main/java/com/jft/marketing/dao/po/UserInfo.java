package com.jft.marketing.dao.po;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo extends BasePo{

    /**
     * 用户微信标识
     * user_info.open_id
     */
    private String openId;

    /**
     * 用户类型
     * user_info.user_type
     */
    private String userType;

    /**
     * user_info.user_phone
     */
    private String userPhone;

    /**
     * 用户类型标记时间
     * user_info.user_type_time
     */
    private Date userTypeTime;

    /**
     * 开放平台才会有
     * user_info.union_id
     */
    private String unionId;

    /**
     * 小程序openid
     * user_info.mini_openid
     */
    private String miniOpenid;
}

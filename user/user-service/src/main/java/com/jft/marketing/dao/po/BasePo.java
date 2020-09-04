package com.jft.marketing.dao.po;


import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class BasePo {

    /**
     * 用户编号
     * user_info.id
     */
    @Id
    private String id;

    /**
     * 乐观锁
     * user_info.REVISION
     */
    private Integer revision;

    /**
     * 创建人
     * user_info.CREATED_BY
     */
    private String createdBy;

    /**
     * 创建时间
     * user_info.CREATED_TIME
     */
    private Date createdTime;

    /**
     * 更新人
     * user_info.UPDATED_BY
     */
    private String updatedBy;

    /**
     * 更新时间
     * user_info.UPDATED_TIME
     */
    private Date updatedTime;

    /**
     * user_info.DELETED
     */
    private Boolean deleted;
}

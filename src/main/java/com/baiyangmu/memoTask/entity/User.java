package com.baiyangmu.memotask.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(User)实体类
 *
 * @author makejava
 * @since 2023-03-11 15:46:52
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 482929675070889787L;
    /**
     * 用户ID
     */
    @JsonProperty("user_id")
    private Integer userId;
    /**
     * 用户名
     */
    @JsonProperty("user_name")
    private String username;
    /**
     * 用户邮箱
     */
    @JsonProperty("email")
    private String email;
    /**
     * 用户密码
     */
    private String password;


    private String salt;


    @JsonProperty("created_by")
    private Integer createdBy;

    @JsonProperty("creation_date")
    private Date creationDate;

    @JsonProperty("last_updated_by")
    private Integer lastUpdatedBy;

    @JsonProperty("last_update_date")
    private Date lastUpdateDate;

}


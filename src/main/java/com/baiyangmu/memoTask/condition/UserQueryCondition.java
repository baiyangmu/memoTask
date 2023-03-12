package com.baiyangmu.memotask.condition;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserQueryCondition {

    /**
     * 用户名
     */
    @JsonProperty("user_name")
    private String username;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户密码
     */
    private String password;


}

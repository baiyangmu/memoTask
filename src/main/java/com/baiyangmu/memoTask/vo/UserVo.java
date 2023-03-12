package com.baiyangmu.memotask.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class UserVo implements Serializable {


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
    @NotBlank(message = "密码必填")
    private String password;

}

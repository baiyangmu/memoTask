package com.baiyangmu.memotask.entity.masterData;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 提醒事项表(Reminder)实体类
 *
 * @author makejava
 * @since 2023-03-11 15:46:23
 */
@Data
public class Reminder implements Serializable {
    private static final long serialVersionUID = -92853914429949964L;
    /**
     * 提醒事项ID
     */
    private Integer reminderId;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 提醒事项标题
     */
    private String title;
    /**
     * 提醒事项内容
     */
    private String content;
    /**
     * 提醒时间
     */
    private Date remindTime;
    
    private Integer createdBy;
    
    private Date creationDate;
    
    private Integer lastUpdatedBy;
    
    private Date lastUpdateDate;

}


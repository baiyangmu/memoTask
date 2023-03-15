package com.baiyangmu.memotask.entity.masterData;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (MemoTag)实体类
 *
 * @author makejava
 * @since 2023-03-11 15:46:09
 */
@Data
public class MemoTag implements Serializable {
    private static final long serialVersionUID = 359361524871698182L;
    
    private Integer memoId;
    
    private Integer tagId;
    
    private Integer createdBy;
    
    private Date creationDate;
    
    private Integer lastUpdatedBy;
    
    private Date lastUpdateDate;

}


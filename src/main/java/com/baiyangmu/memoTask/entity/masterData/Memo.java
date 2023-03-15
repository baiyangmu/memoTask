package com.baiyangmu.memotask.entity.masterData;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Memo)实体类
 *
 * @author makejava
 * @since 2023-03-11 15:44:33
 */
@Data
public class Memo implements Serializable {
    private static final long serialVersionUID = -29014854550141747L;
    
    private Integer memoId;
    
    private String title;
    
    private String content;
    
    private Integer status;
    
    private Integer createdBy;
    
    private Date creationDate;
    
    private Integer lastUpdatedBy;
    
    private Date lastUpdateDate;

}


package com.baiyangmu.memotask.entity.masterData;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Tag)实体类
 *
 * @author makejava
 * @since 2023-03-11 15:46:40
 */
@Data
public class Tag implements Serializable {
    private static final long serialVersionUID = 378712983771620133L;
    
    private Integer tagId;
    
    private String name;
    
    private Integer createdBy;
    
    private Date creationDate;
    
    private Integer lastUpdatedBy;
    
    private Date lastUpdateDate;

}


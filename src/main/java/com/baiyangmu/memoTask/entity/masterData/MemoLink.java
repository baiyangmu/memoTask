package com.baiyangmu.memotask.entity.masterData;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 备忘录关联表(MemoLink)实体类
 *
 * @author makejava
 * @since 2023-03-11 15:45:52
 */
@Data
public class MemoLink implements Serializable {
    private static final long serialVersionUID = 295698629712841993L;
    /**
     * 关联关系ID
     */
    private Integer linkId;
    /**
     * 备忘录ID
     */
    private Integer sourceMemoId;
    /**
     * 关联备忘录ID
     */
    private Integer targetMemoId;
    
    private Integer createdBy;
    
    private Date creationDate;
    
    private Integer lastUpdatedBy;
    
    private Date lastUpdateDate;

}


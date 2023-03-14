package com.baiyangmu.memotask.entity.masterData;

import java.util.Date;
import java.io.Serializable;

/**
 * 备忘录关联表(MemoLink)实体类
 *
 * @author makejava
 * @since 2023-03-11 15:45:52
 */
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


    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Integer getSourceMemoId() {
        return sourceMemoId;
    }

    public void setSourceMemoId(Integer sourceMemoId) {
        this.sourceMemoId = sourceMemoId;
    }

    public Integer getTargetMemoId() {
        return targetMemoId;
    }

    public void setTargetMemoId(Integer targetMemoId) {
        this.targetMemoId = targetMemoId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

}


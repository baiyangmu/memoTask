package com.baiyangmu.memotask.entity.masterData;

import java.util.Date;
import java.io.Serializable;

/**
 * (MemoTag)实体类
 *
 * @author makejava
 * @since 2023-03-11 15:46:09
 */
public class MemoTag implements Serializable {
    private static final long serialVersionUID = 359361524871698182L;
    
    private Integer memoId;
    
    private Integer tagId;
    
    private Integer createdBy;
    
    private Date creationDate;
    
    private Integer lastUpdateBy;
    
    private Date lastUpdateDate;


    public Integer getMemoId() {
        return memoId;
    }

    public void setMemoId(Integer memoId) {
        this.memoId = memoId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
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

    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

}


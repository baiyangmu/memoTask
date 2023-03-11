package com.baiyangmu.memotask.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Memo)实体类
 *
 * @author makejava
 * @since 2023-03-11 15:44:33
 */
public class Memo implements Serializable {
    private static final long serialVersionUID = -29014854550141747L;
    
    private Integer memoId;
    
    private String title;
    
    private String content;
    
    private Integer status;
    
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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


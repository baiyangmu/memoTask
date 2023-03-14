package com.baiyangmu.memotask.entity.masterData;

import java.util.Date;
import java.io.Serializable;

/**
 * (Tag)实体类
 *
 * @author makejava
 * @since 2023-03-11 15:46:40
 */
public class Tag implements Serializable {
    private static final long serialVersionUID = 378712983771620133L;
    
    private Integer tagId;
    
    private String name;
    
    private Integer createdBy;
    
    private Date creationDate;
    
    private Integer lastUpdateBy;
    
    private Date lastUpdateDate;


    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


package com.politics.chn.domain.user.Entity;

import java.util.Date;
import java.util.Objects;

/**
 * @author xu
 * @create 2021-03-31 21:13
 */

public class RoleDO {

    private Long id;

    private String name;

    private String description;

    private Long count;

    private Date createTime;

    private Integer sort;

    private Boolean enabled;
    private Boolean deleted;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoleDO roleDO = (RoleDO) o;
        return Objects.equals(id, roleDO.id) && Objects.equals(name, roleDO.name) && Objects.equals(description, roleDO.description) && Objects.equals(count, roleDO.count) && Objects.equals(createTime, roleDO.createTime) && Objects.equals(sort, roleDO.sort) && Objects.equals(enabled, roleDO.enabled) && Objects.equals(deleted, roleDO.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, count, createTime, sort, enabled, deleted);
    }

    @Override
    public String toString() {
        return "RoleDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", count=" + count +
                ", createTime=" + createTime +
                ", sort=" + sort +
                ", enabled=" + enabled +
                ", deleted=" + deleted +
                '}';
    }

    public boolean isNotNull() {
        return name != null;
    }
}

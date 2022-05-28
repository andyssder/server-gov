package com.politics.chn.repo.user.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

/**
 * @since 2021-03-31
 * @author andyssder
 */

public class RolePO {

    private Long id;

    private String name;

    private String description;

    private Long count;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
        RolePO rolePO = (RolePO) o;
        return Objects.equals(id, rolePO.id) && Objects.equals(name, rolePO.name) && Objects.equals(description, rolePO.description) && Objects.equals(count, rolePO.count) && Objects.equals(createTime, rolePO.createTime) && Objects.equals(sort, rolePO.sort) && Objects.equals(enabled, rolePO.enabled) && Objects.equals(deleted, rolePO.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, count, createTime, sort, enabled, deleted);
    }

    @Override
    public String toString() {
        return "RolePO{" +
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

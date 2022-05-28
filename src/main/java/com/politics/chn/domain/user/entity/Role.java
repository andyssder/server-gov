package com.politics.chn.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.politics.chn.domain.common.Entity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

/**
 * @since 2021-03-31
 * @author xu
 */

public class Role implements Entity {

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
        Role role = (Role) o;
        return Objects.equals(id, role.id) && Objects.equals(name, role.name) && Objects.equals(description, role.description) && Objects.equals(count, role.count) && Objects.equals(createTime, role.createTime) && Objects.equals(sort, role.sort) && Objects.equals(enabled, role.enabled) && Objects.equals(deleted, role.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, count, createTime, sort, enabled, deleted);
    }

    @Override
    public String toString() {
        return "Role{" +
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

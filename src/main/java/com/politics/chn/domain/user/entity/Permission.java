package com.politics.chn.domain.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.politics.chn.domain.common.Entity;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

/**
 * @since 2021-04-03
 * @author andyssder
 */
public class Permission implements Entity {
    private Long id;
    private Long pid;
    private String name;
    private String description;
    /**
     * 资源类型 前端页面/后端接口
     */
    private Integer type;
    /**
     * 资源路径
     */
    private String uri;
    /**
     * 资源访问方法(后端接口)
     */
    private String method;

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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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
        Permission that = (Permission) o;
        return Objects.equals(id, that.id) && Objects.equals(pid, that.pid) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(type, that.type) && Objects.equals(uri, that.uri) && Objects.equals(method, that.method) && Objects.equals(createTime, that.createTime) && Objects.equals(sort, that.sort) && Objects.equals(enabled, that.enabled) && Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, name, description, type, uri, method, createTime, sort, enabled, deleted);
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", uri='" + uri + '\'' +
                ", method='" + method + '\'' +
                ", createTime=" + createTime +
                ", sort=" + sort +
                ", enabled=" + enabled +
                ", deleted=" + deleted +
                '}';
    }

    public boolean isNotNull() {
        return name != null && type != null && uri != null;
    }
}

package com.politics.chn.domain.user.Entity;

import java.util.Date;
import java.util.Objects;

/**
 * @author xu
 * @create 2021-04-03 21:38
 */
public class PermissionDO {
    private Long id;
    private Long pid;
    private String name;
    private String value;
    private String icon;
    // 权限类型
    private Integer type;
    // 前端资源路径
    private String uri;
    private Boolean enabled;
    private Date createTime;
    private Integer sort;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PermissionDO that = (PermissionDO) o;
        return Objects.equals(id, that.id) && Objects.equals(pid, that.pid) && Objects.equals(name, that.name) && Objects.equals(value, that.value) && Objects.equals(icon, that.icon) && Objects.equals(type, that.type) && Objects.equals(uri, that.uri) && Objects.equals(enabled, that.enabled) && Objects.equals(createTime, that.createTime) && Objects.equals(sort, that.sort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, name, value, icon, type, uri, enabled, createTime, sort);
    }

    @Override
    public String toString() {
        return "PermissionDO{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", icon='" + icon + '\'' +
                ", type=" + type +
                ", uri='" + uri + '\'' +
                ", enabled=" + enabled +
                ", createTime=" + createTime +
                ", sort=" + sort +
                '}';
    }
}

package com.politics.chn.repo.user.po;

import java.util.Objects;

/**
 * @since 2021-04-18
 * @author xu
 */
public class UserRoleRelationPO {
    Long id;
    Long userId;
    Long roleId;

    public UserRoleRelationPO(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserRoleRelationPO that = (UserRoleRelationPO) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, roleId);
    }

    @Override
    public String toString() {
        return "UserRoleRelationPO{" +
                "id=" + id +
                ", userId=" + userId +
                ", roleId=" + roleId +
                '}';
    }
}

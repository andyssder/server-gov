package com.politics.chn.domain.user.Entity;

import java.util.Objects;

/**
 * @author xu
 * @create 2021-04-18 09:18
 */
public class RolePermissionRelation {
    Long id;
    Long roleId;
    Long permissionId;

    public RolePermissionRelation(Long roleId, Long permissionId) {
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RolePermissionRelation that = (RolePermissionRelation) o;
        return Objects.equals(id, that.id) && Objects.equals(roleId, that.roleId) && Objects.equals(permissionId, that.permissionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, permissionId);
    }

    @Override
    public String toString() {
        return "RolePermissionRelation{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                '}';
    }
}

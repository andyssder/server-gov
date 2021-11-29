package com.politics.chn.repo.user.dao.mapper;

import com.politics.chn.repo.user.po.RolePermissionRelationPO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author xu
 * @since 2021-11-28
 */
@Mapper
public interface RolePermissionRelationMapper {

    @Insert("INSERT INTO sys_role_permission(role_id, permission_id) " +
            "VALUES(#{roleId}, #{permissionId})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOneRolePermissionRelation(RolePermissionRelationPO rolePermissionRelationPO);

    @Delete("Delete FROM sys_role_permission WHERE role_id = #{roleId}")
    int deleteRolePermissionRelationByRoleId(long roleId);
}

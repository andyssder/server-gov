package com.politics.chn.repo.user.dao.mapper;

import com.politics.chn.repo.user.po.UserRoleRelationPO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author xu
 * @since 2021-11-28
 */
@Mapper
public interface UserRoleRelationMapper {
    @Insert("INSERT INTO sys_user_role(user_id, role_id) " +
            "VALUES(#{userId}, #{roleId})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOneUserRoleRelation(UserRoleRelationPO userRoleRelationPO);

    @Delete("Delete FROM sys_user_role WHERE user_id = #{userId}")
    int deleteUserRoleRelationByUserId(long userId);
}

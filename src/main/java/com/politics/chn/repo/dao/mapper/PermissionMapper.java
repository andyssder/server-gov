package com.politics.chn.repo.dao.mapper;

import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.domain.user.Entity.RolePermissionRelation;
import com.politics.chn.domain.user.Entity.UserRoleRelation;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xu
 * @create 2021-04-03 21:46
 */
@Mapper
public interface PermissionMapper {

    @Select("SELECT * FROM sys_permission WHERE is_deleted = false ORDER BY type, sort")
    @Results(id="permission", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted")
    })
    List<PermissionDO> getAll();

    // TODO 优化查询代码, 考虑user role permission 怎么更好的查询
    @Select("<script> " +
            "SELECT p.* " +
            "FROM " +
            "sys_user_role ur " +
            "LEFT JOIN sys_role r ON r.id=ur.role_id " +
            "LEFT JOIN sys_role_permission rp ON rp.role_id=r.id " +
            "LEFT JOIN sys_permission p ON p.id=rp.permission_id " +
            "WHERE " +
            "ur.user_id=#{userId} " +
            "AND p.id IS NOT NULL" +
            "</script>")
    @ResultMap("permission")
    List<PermissionDO> getListByUserId(long userId);

    @Insert("INSERT INTO sys_permission(pid, name, description, type, uri, sort, create_time) " +
            "VALUES(#{pid}, #{name}, #{description}, #{type}, #{uri}, #{sort}, #{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(PermissionDO permission);

    @Update("<script> " +
            "UPDATE sys_permission" +
            "<trim prefix='set' suffixOverrides=',' suffix=' where id = #{id}'>" +
            "<if test='name != null'> name=#{name}, </if>" +
            "<if test='description != null'> description=#{description}, </if>" +
            "<if test='type != null'> type=#{type}, </if>" +
            "<if test='uri != null'> uri=#{uri}, </if>" +
            "<if test='sort != null'> sort=#{sort}, </if>" +
            "<if test='enabled != null'> is_enabled=#{enabled}, </if>" +
            "<if test='deleted != null'> is_deleted=#{deleted}, </if>" +
            "</trim>" +
            "</script>")
    int updateOne(PermissionDO permission);

    @Update("<script>" +
            "UPDATE sys_permission" +
            "<set>" +
            "<trim prefix='name=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.name != null'>" +
            "when id=#{item.id} then #{item.name} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='description=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.description != null'>" +
            "when id=#{item.id} then #{item.description} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='type=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.type != null'>" +
            "when id=#{item.id} then #{item.type} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='uri=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.uri != null'>" +
            "when id=#{item.id} then #{item.uri} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='sort=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.sort != null'>" +
            "when id=#{item.id} then #{item.sort} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='enabled=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.enabled != null'>" +
            "when id=#{item.id} then #{item.enabled} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='deleted=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.deleted != null'>" +
            "when id=#{item.id} then #{item.deleted} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "</set>" +
            "where id in" +
            "<foreach collection='list' item='item' index='index' separator=',' open='(' close=')'>" +
            " #{item.id}" +
            "</foreach>" +
            "</script>")
    int updateMany(List<PermissionDO> permissions);

    @Update("UPDATE sys_permission SET is_deleted = true WHERE id = #{id}")
    int deleteOne(long id);

    @Delete("Delete FROM sys_permission WHERE id = #{id}")
    int realDeleteOne(long id);

    @Insert("INSERT INTO sys_role_permission(role_id, permission_id) " +
            "VALUES(#{roleId}, #{permissionId})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOneRolePermissionRelation(RolePermissionRelation rolePermissionRelation);

    @Delete("Delete FROM sys_role_permission WHERE role_id = #{roleId}")
    int deleteRolePermissionRelationByRoleId(long roleId);

}

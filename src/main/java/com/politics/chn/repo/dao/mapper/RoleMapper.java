package com.politics.chn.repo.dao.mapper;

import com.politics.chn.domain.user.Entity.RoleDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xu
 * @create 2021-04-03 21:52
 */
@Mapper
public interface RoleMapper {

    @Select("SELECT * FROM sys_role WHERE is_deleted = false ORDER BY sort ASC")
    @Results(id="role", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted")
    })
    List<RoleDO> getAll();

    @Select("<script> " +
            "SELECT r.* " +
            "FROM sys_role r, sys_user_role ur " +
            "WHERE ur.user_id=#{userId} AND ur.role_id=r.id" +
            "</script>")
    @ResultMap("role")
    List<RoleDO> getListByUserId(long userId);

    @Insert("INSERT INTO sys_role(name, description, count, create_time, sort) " +
            "VALUES(#{name}, #{description}, #{count}, #{create_time}, #{sort})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(RoleDO role);

    @Update("<script> " +
            "UPDATE sys_role" +
            "<trim prefix='set' suffixOverrides=',' suffix=' where id = #{id}'>" +
            "<if test='name != null'> name=#{name}, </if>" +
            "<if test='description != null'> description=#{description}, </if>" +
            "<if test='count != null'> count=#{count}, </if>" +
            "<if test='sort != null'> sort=#{sort}, </if>" +
            "<if test='enabled != null'> is_enabled=#{enabled}, </if>" +
            "<if test='deleted != null'> is_deleted=#{deleted}, </if>" +
            "</trim>" +
            "</script>")
    int updateOne(RoleDO role);

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
            "<trim prefix='count=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.count != null'>" +
            "when id=#{item.id} then #{item.count} " +
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
    int updateMany(List<RoleDO> roles);

    @Update("UPDATE sys_role SET is_deleted = true WHERE id = #{id}")
    int deleteOne(long id);

    @Delete("Delete FROM sys_role WHERE id = #{id}")
    int realDeleteOne(long id);

}

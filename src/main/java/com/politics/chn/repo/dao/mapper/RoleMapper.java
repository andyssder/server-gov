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

    @Select("SELECT * FROM sys_role where is_deleted = false")
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

    @Update("UPDATE sys_role SET is_deleted = true WHERE id = #{id}")
    int deleteOne(long id);

    @Delete("Delete FROM sys_role WHERE id = #{id}")
    int realDeleteOne(long id);

}

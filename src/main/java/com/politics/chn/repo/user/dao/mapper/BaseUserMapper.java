package com.politics.chn.repo.user.dao.mapper;

import com.politics.chn.repo.user.po.BaseUserPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xu
 * @since 2021-03-31 22:32
 */
@Mapper
public interface BaseUserMapper {

    @Select("SELECT * FROM sys_user WHERE is_deleted = false")
    @Results(id="user", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted")
    })
    List<BaseUserPO> getAll();

    @Select("SELECT * FROM sys_user WHERE ${field} = #{value} LIMIT 1")
    @ResultMap("user")
    BaseUserPO getOneByField(String field, String value);

    @Insert("INSERT INTO sys_user(username, password, icon, description, email, phone, create_time) VALUES(#{username}, #{password}, #{icon}, #{description}, #{email}, #{phone}, #{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(BaseUserPO baseUser);

}

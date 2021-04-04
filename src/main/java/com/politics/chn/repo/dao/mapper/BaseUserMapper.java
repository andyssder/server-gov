package com.politics.chn.repo.dao.mapper;

import com.politics.chn.domain.user.Entity.BaseUserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author xu
 * @create 2021-03-31 22:32
 */
@Mapper
public interface BaseUserMapper {
    @Select("SELECT * FROM user WHERE ${field} = #{value} LIMIT 0, 1")
    BaseUserDO getOneByField(String field, String value);

    @Insert("INSERT INTO user(username, password, icon, description, email, phone, create_time) VALUES(#{username}, #{password}, #{icon}, #{description}, #{email}, #{phone}, #{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(BaseUserDO baseUser);
}

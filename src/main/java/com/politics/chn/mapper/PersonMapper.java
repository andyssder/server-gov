package com.politics.chn.mapper;

import com.politics.chn.model.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PersonMapper {
    @Select("SELECT * FROM person")
    List<Person> getAll();

    @Select("SELECT * FROM person WHERE id = #{id}")
    Person getOne(int id);

    @Insert("INSERT INTO person(name,gender) VALUES(#{name}, #{gender})")
    void insert(Person person);

    @Update("UPDATE person SET userName=#{userName},nick_name=#{nickName} WHERE id =#{id}")
    void update(Person person);

    @Delete("DELETE FROM person WHERE id =#{id}")
    void delete(int id);

}

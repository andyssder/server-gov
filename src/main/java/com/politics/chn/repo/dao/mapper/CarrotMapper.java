package com.politics.chn.repo.dao.mapper;

import com.politics.chn.model.domain.value.CarrotDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author andyssder
 * @create 2021-02-18 11:21
 */
@Mapper
public interface CarrotMapper {
    @Select("SELECT * FROM carrot")
    List<CarrotDO> getAll();

    @Select("SELECT * FROM carrot WHERE pit_level = #{pitLevel}")
    List<CarrotDO> getByPitLevel(int pitLevel);

    @Select("SELECT * FROM carrot WHERE id = #{id}")
    CarrotDO getOneById(long id);

    @Insert("INSERT INTO carrot(name, short_name, pit_level) VALUES(#{name}, #{shortName}, #{pitLevel})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(CarrotDO carrotDO);

    @Update("<script> " +
            "UPDATE carrot SET" +
            "<foreach item='value' index='key' collection='updateParams.entrySet()' separator=','>" +
            "${key} = #{value}" +
            "</foreach>" +
            "WHERE id = #{id}" +
            "</script>")
    int updateOne(long id, Map<String, Object> updateParams);

    @Update("UPDATE carrot SET is_deleted = true WHERE id = #{id}")
    int deleteOne(long id);

    @Delete("Delete FROM carrot WHERE id = #{id}")
    int realDeleteOne(long id);
}

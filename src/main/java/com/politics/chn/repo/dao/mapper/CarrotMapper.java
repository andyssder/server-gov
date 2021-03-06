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
    @Select("SELECT * FROM carrot where is_deleted = false")
    @Results(id="carrot", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted")
    })
    List<CarrotDO> getAll();

    @Select("SELECT * FROM carrot WHERE pit_level = #{districtLevel} and where is_deleted = false")
    @ResultMap("carrot")
    List<CarrotDO> getByDistrictLevel(int districtLevel);

    @Select("SELECT * FROM carrot WHERE id = #{id} and where is_deleted = false")
    @ResultMap("carrot")
    CarrotDO getOneById(long id);

    @Insert("INSERT INTO carrot(name, short_name, pit_level, is_enabled) VALUES(#{name}, #{shortName}, #{districtLevel}, #{enabled})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(CarrotDO carrotDO);

    @Update("<script> " +
            "UPDATE carrot" +
            "<trim prefix='set' suffixOverrides=',' suffix=' where id = #{id}'>" +
            "<if test='name != null'> name=#{name}, </if>" +
            "<if test='shortName != null'> short_name=#{shortName}, </if>" +
            "<if test='districtLevel != null'> pit_level=#{districtLevel}, </if>" +
            "<if test='enabled != null'> is_enabled=#{enabled}, </if>" +
            "<if test='deleted != null'> is_deleted=#{deleted}, </if>" +
            "</trim>" +
            "</script>")
    int updateOne(CarrotDO carrotDO);

    @Update("UPDATE carrot SET is_deleted = true WHERE id = #{id}")
    int deleteOne(long id);

    @Delete("Delete FROM carrot WHERE id = #{id}")
    int realDeleteOne(long id);
}

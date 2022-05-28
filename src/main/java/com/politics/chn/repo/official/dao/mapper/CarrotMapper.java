package com.politics.chn.repo.official.dao.mapper;

import com.politics.chn.repo.official.po.CarrotPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @since 2021-02-18
 * @author andyssder
 */
@Mapper
public interface CarrotMapper {
    @Select("SELECT * FROM carrot WHERE is_deleted = false order by district_level")
    @Results(id="carrot", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted")
    })
    List<CarrotPO> getAll();

    @Select("SELECT * FROM carrot WHERE district_level = #{districtLevel} and is_deleted = false")
    @ResultMap("carrot")
    List<CarrotPO> getByDistrictLevel(int districtLevel);

    @Select("SELECT * FROM carrot WHERE id = #{id} LIMIT 1")
    @ResultMap("carrot")
    CarrotPO getOneById(long id);

    @Insert("INSERT INTO carrot(name, short_name, district_level, is_enabled) VALUES(#{name}, #{shortName}, #{districtLevel}, #{enabled})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(CarrotPO carrot);

    @Update("<script> " +
            "UPDATE carrot" +
            "<trim prefix='set' suffixOverrides=',' suffix=' where id = #{id}'>" +
            "<if test='name != null'> name=#{name}, </if>" +
            "<if test='shortName != null'> short_name=#{shortName}, </if>" +
            "<if test='districtLevel != null'> district_level=#{districtLevel}, </if>" +
            "<if test='enabled != null'> is_enabled=#{enabled}, </if>" +
            "<if test='deleted != null'> is_deleted=#{deleted}, </if>" +
            "</trim>" +
            "</script>")
    int updateOne(CarrotPO carrot);

    @Update("UPDATE carrot SET is_deleted = true WHERE id = #{id}")
    int deleteOne(long id);

    @Delete("Delete FROM carrot WHERE id = #{id}")
    int realDeleteOne(long id);
}

package com.politics.chn.repo.dao.mapper;

import com.politics.chn.model.domain.value.PitDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-08 17:29
 */
@Mapper
public interface PitMapper {
    @Select("SELECT * FROM pit where is_deleted = false and level != 0")
    @Results(id="pit", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted")
    })
    List<PitDO> getAll();

    @Select("SELECT * FROM pit WHERE is_deleted = false AND district_level = #{districtLevel}")
    @ResultMap("pit")
    List<PitDO> getByDistrictLevel(int districtLevel);

    @Select("SELECT * FROM pit WHERE is_deleted = false AND lft > #{lft} AND rgt < #{rgt} AND level=#{level} + 1 ORDER BY lft ASC")
    @ResultMap("pit")
    List<PitDO> getLower(int lft, int rgt, int level);

    @Select("SELECT * FROM pit WHERE id = #{id} and is_deleted = false")
    @ResultMap("pit")
    PitDO getOneById(long id);

    @Insert("INSERT INTO pit(name, short_name, level, district_level, lft, rgt, pid, is_enabled, ranking) VALUES(#{name}, #{shortName}, #{level}, #{districtLevel}, #{lft}, #{rgt}, #{pid}, #{enabled}, #{ranking})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(PitDO pit);

    // TODO: 存在设置某个属性为null不成功的情况
    @Update("<script> " +
            "UPDATE pit" +
            "<trim prefix='set' suffixOverrides=',' suffix=' where id = #{id}'>" +
            "<if test='name != null'> name=#{name}, </if>" +
            "<if test='shortName != null'> short_name=#{shortName}, </if>" +
            "<if test='level != null'> level=#{level}, </if>" +
            "<if test='ranking != null'> level=#{ranking}, </if>" +
            "<if test='districtLevel != null'> district_level=#{districtLevel}, </if>" +
            "<if test='lft != null'> lft=#{lft}, </if>" +
            "<if test='rgt != null'> rgt=#{rgt}, </if>" +
            "<if test='pid != null'> pid=#{pid}, </if>" +
            "<if test='enabled != null'> is_enabled=#{enabled}, </if>" +
            "<if test='deleted != null'> is_deleted=#{deleted}, </if>" +
            "</trim>" +
            "</script>")
    int updateOne(PitDO pit);

    @Update("UPDATE pit SET is_deleted = true WHERE id = #{id}")
    int deleteOne(long id);

    @Delete("Delete FROM pit WHERE id = #{id}")
    int realDeleteOne(long id);
}

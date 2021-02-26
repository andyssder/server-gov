package com.politics.chn.repo.dao.mapper;

import com.politics.chn.model.domain.value.PitDO;
import com.politics.chn.model.po.PitPO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author andyssder
 * @create 2021-02-08 17:29
 */
@Mapper
public interface PitMapper {
    @Select("SELECT * FROM pit")
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

    @Select("SELECT * FROM pit WHERE id = #{id}")
    @ResultMap("pit")
    PitDO getOneById(long id);

    @Insert("INSERT INTO pit(name, short_name, level, rank, district_level, lft, rgt, pid) VALUES(#{name}, #{shortName}, #{level}, #{rank}, #{districtLevel}, #{lft}, #{rgt}, #{pid})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(PitPO pitPO);

    // TODO: 存在设置某个属性为null不成功的情况
    @Update("<script> " +
            "UPDATE pit" +
            "<trim prefix='set' suffixOverrides=',' suffix=' where id = #{id}'>" +
            "<if test='name != null'> name=#{name}, </if>" +
            "<if test='shortName != null'> short_name=#{shortName}, </if>" +
            "<if test='level != null'> level=#{level}, </if>" +
            "<if test='rank != null'> level=#{rank}, </if>" +
            "<if test='districtLevel != null'> district_level=#{districtLevel}, </if>" +
            "<if test='lft != null'> lft=#{lft}, </if>" +
            "<if test='rgt != null'> rgt=#{rgt}, </if>" +
            "<if test='pid != null'> pid=#{pid}, </if>" +
            "<if test='deleted != null'> is_deleted=#{deleted}, </if>" +
            "</trim>" +
            "</script>")
    int updateOne(PitPO pitPO);

    @Update("UPDATE pit SET is_deleted = true WHERE id = #{id}")
    int deleteOne(long id);

    @Delete("Delete FROM pit WHERE id = #{id}")
    int realDeleteOne(long id);
}

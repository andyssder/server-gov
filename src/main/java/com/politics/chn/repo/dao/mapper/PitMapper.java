package com.politics.chn.repo.dao.mapper;

import com.politics.chn.model.domain.value.PitDO;
import com.politics.chn.model.po.PitPO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author: andyssder
 * @create: 2021-02-08 17:29
 */
@Mapper
public interface PitMapper {
    @Select("SELECT * FROM pit")
    List<PitDO> getAll();

    @Select("SELECT * FROM pit WHERE is_deleted = false AND district_level = #{districtLevel}")
    List<PitDO> getByDistrictLevel(int districtLevel);

    @Select("SELECT * FROM pit WHERE is_deleted = false AND lft > #{lft} AND rgt < #{rgt} AND level=#{level} + 1 ORDER BY lft ASC")
    List<PitDO> getLower(int lft, int rgt, int level);

    @Select("SELECT * FROM pit WHERE id = #{id}")
    PitDO getOneById(long id);

    @Insert("INSERT INTO pit(name, short_name, level, rank, district_level, lft, rgt, pid) VALUES(#{name}, #{shortName}, #{level}, #{rank}, #{districtLevel}, #{lft}, #{rgt}, #{pid})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(PitPO pitPO);

    @Update("<script> " +
            "UPDATE pit SET" +
            "<foreach item='value' index='key' collection='updateParams.entrySet()' separator=','>" +
            "${key} = #{value}" +
            "</foreach>" +
            "WHERE id = #{id}" +
            "</script>")
    int updateOne(long id, Map<String, Object> updateParams);

    @Update("UPDATE pit SET is_deleted = true WHERE id = #{id}")
    int deleteOne(long id);

    @Delete("Delete FROM pit WHERE id = #{id}")
    int realDeleteOne(long id);
}

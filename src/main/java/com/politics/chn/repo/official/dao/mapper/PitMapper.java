package com.politics.chn.repo.official.dao.mapper;

import com.politics.chn.repo.official.po.PitPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @since 2021-02-08
 * @author andyssder
 */
@Mapper
public interface PitMapper {
    @Select("SELECT * FROM pit WHERE is_deleted = false and level != 0")
    @Results(id="pit", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted")
    })
    List<PitPO> getAll();

    @Select("SELECT * FROM pit WHERE is_deleted = false AND district_id = #{districtId}")
    @ResultMap("pit")
    List<PitPO> getByDistrictId(int districtId);

    @Select("SELECT * FROM pit WHERE is_deleted = false AND pid = #{pid} ORDER BY sort")
    @ResultMap("pit")
    List<PitPO> getChildren(long pid);

    @Select("SELECT count(1) FROM pit WHERE is_deleted = false AND pid = #{pid}")
    Long countChildren(long pid);

    @Select("SELECT * FROM pit WHERE id = #{id} and is_deleted = false LIMIT 1")
    @ResultMap("pit")
    PitPO getOneById(long id);

    @Insert("INSERT INTO pit(name, short_name, pid, level, type, ranking, district_level, district_id, sort, is_enabled) " +
            "VALUES(#{name}, #{shortName}, #{pid}, #{level}, #{type}, #{ranking}, #{districtLevel}, #{districtId}, #{sort}, #{enabled} )")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(PitPO pit);

    // TODO: 存在设置某个属性为null不成功的情况
    @Update("<script> " +
            "UPDATE pit" +
            "<trim prefix='set' suffixOverrides=',' suffix=' WHERE id = #{id}'>" +
            "<if test='name != null'> name=#{name}, </if>" +
            "<if test='shortName != null'> short_name=#{shortName}, </if>" +
            "<if test='pid != null'> pid=#{pid}, </if>" +
            "<if test='level != null'> level=#{level}, </if>" +
            "<if test='type != null'> type=#{type}, </if>" +
            "<if test='ranking != null'> ranking=#{ranking}, </if>" +
            "<if test='districtLevel != null'> district_level=#{districtLevel}, </if>" +
            "<if test='districtId != null'> district_id=#{districtId}, </if>" +
            "<if test='sort != null'> sort=#{sort}, </if>" +
            "<if test='enabled != null'> is_enabled=#{enabled}, </if>" +
            "<if test='deleted != null'> is_deleted=#{deleted}, </if>" +
            "</trim>" +
            "</script>")
    int updateOne(PitPO pit);

    @Update("UPDATE pit SET is_deleted = true WHERE id = #{id}")
    int deleteOne(long id);

    @Delete("Delete FROM pit WHERE id = #{id}")
    int realDeleteOne(long id);
}

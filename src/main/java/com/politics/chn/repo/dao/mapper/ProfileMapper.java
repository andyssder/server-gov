package com.politics.chn.repo.dao.mapper;

import com.politics.chn.domain.official.entity.ProfileDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-19 21:34
 */
@Mapper
public interface ProfileMapper {
    @Select("SELECT * FROM profile where is_deleted = false")
    @Results(id="profile", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted"),
            @Result(property="district",column="district_id"),
            @Result(property="pit",column="pit_id"),
            @Result(property="carrot",column="carrot_id")
    })
    List<ProfileDO> getAll();

    @Select("SELECT * FROM profile WHERE person_id = #{personId} and is_deleted = false ORDER BY start_time, priority")
    @ResultMap("profile")
    List<ProfileDO> getByPersonId(long personId);

    @Select("SELECT * FROM profile WHERE id = #{id}")
    @ResultMap("profile")
    ProfileDO getOneById(long id);

    @Insert("INSERT INTO profile(" +
            "start_time, end_time, person_id, " +
            "district_id, pit_id, carrot_id, " +
            "remark, summary, priority, is_enabled) " +
            "VALUES(" +
            "#{startTime}, #{endTime}, #{personId}, " +
            "#{district}, #{pit}, #{carrot}, " +
            "#{remark}, #{summary}, #{priority}, #{enabled})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(ProfileDO profile);

    @Insert("<script> INSERT INTO profile " +
            "(start_time, end_time, person_id, district_id, pit_id, carrot_id, remark, summary, priority, is_enabled) " +
            "VALUES " +
            "<foreach collection='list' item='item' separator=',' > " +
            "(#{item.startTime}, #{item.endTime}, #{item.personId}, " +
            "#{item.district}, #{item.pit}, #{item.carrot}, " +
            "#{item.remark}, #{item.summary}, #{item.priority}, #{item.enabled}) " +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertMany(List<ProfileDO> profiles);

    // TODO: 存在设置某个属性为null不成功的情况
    @Update("<script> " +
            "UPDATE profile" +
            "<trim prefix='set' suffixOverrides=',' suffix=' where id = #{id}'>" +
            "<if test='startTime != null'> start_time=#{startTime}, </if>" +
            "<if test='endTime != null'> end_time=#{endTime}, </if>" +
            "<if test='personId != null'> person_id=#{personId}, </if>" +
            "<if test='district != null'> district_id=#{district}, </if>" +
            "<if test='pit != null'> pit_id=#{pit}, </if>" +
            "<if test='carrot != null'> carrot_id=#{carrot}, </if>" +
            "<if test='remark != null'> remark=#{remark}, </if>" +
            "<if test='summary != null'> summary=#{summary}, </if>" +
            "<if test='priority != null'> priority=#{priority}, </if>" +
            "<if test='enabled != null'> is_enabled=#{enabled}, </if>" +
            "<if test='deleted != null'> is_deleted=#{deleted}, </if>" +
            "</trim>" +
            "</script>")
    int updateOne(ProfileDO profile);

    @Insert("<script> INSERT INTO profile " +
            "(id, start_time, end_time, person_id, district_id, pit_id, carrot_id, remark, summary, priority, is_deleted, is_enabled) " +
            "VALUES " +
            "<foreach collection='list' item='item' separator=',' > " +
            "(#{item.id}, #{item.startTime}, #{item.endTime}, #{item.personId}, " +
            "#{item.district}, #{item.pit}, #{item.carrot}, " +
            "#{item.remark}, #{item.summary}, #{item.priority}, #{item.deleted}, #{item.enabled}) " +
            "</foreach>" +
            "ON DUPLICATE KEY UPDATE " +
            "id = VALUES(id)," +
            "start_time = VALUES(start_time)," +
            "end_time = VALUES(end_time)," +
            "person_id = VALUES(person_id)," +
            "district_id = VALUES(district_id)," +
            "pit_id = VALUES(pit_id)," +
            "carrot_id = VALUES(carrot_id)," +
            "remark = VALUES(remark)," +
            "summary = VALUES(summary)," +
            "priority = VALUES(priority)," +
            "is_deleted = VALUES(is_deleted)," +
            "is_enabled = VALUES(is_enabled)" +
            "</script>")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int updateMany(List<ProfileDO> profiles);

    @Update("UPDATE profile SET is_deleted = true WHERE ${field} = #{value}")
    int deleteOne(String field, long value);

    @Delete("Delete FROM profile WHERE ${field} = #{value}")
    int realDeleteOne(String field, long value);

}

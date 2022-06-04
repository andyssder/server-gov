package com.politics.chn.repo.official.dao.mapper;

import com.politics.chn.repo.official.po.ProfilePO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @since 2021-02-19 21:34
 * @author andyssder
 */
@Mapper
public interface ProfileMapper {
    @Select("SELECT * FROM profile WHERE is_deleted = false")
    @Results(id="profile", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted")
    })
    List<ProfilePO> getAll();

    @Select("SELECT * FROM profile WHERE person_id = #{personId} and is_deleted = false ORDER BY start_time, priority")
    @ResultMap("profile")
    List<ProfilePO> getByPersonId(long personId);

    @Select("SELECT * FROM profile WHERE id = #{id} LIMIT 1")
    @ResultMap("profile")
    ProfilePO getOneById(long id);

    @Insert("INSERT INTO profile(" +
            "start_time, end_time, person_id, district_id, " +
            "pit_id, carrot_id, remark, summary, " +
            "priority, pid, type, ranking, is_enabled) " +
            "VALUES(" +
            "#{startTime}, #{endTime}, #{personId}, #{districtId}, " +
            "#{pitId}, #{carrotId}, #{remark}, {summary}, " +
            "##{priority}, #{pid}, #{type}, #{ranking}, #{enabled})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(ProfilePO profile);

    @Insert("<script> INSERT INTO profile " +
            "(start_time, end_time, person_id, district_id, " +
            "pit_id, carrot_id, remark, summary, " +
            "priority, pid, type, ranking, is_enabled) " +
            "VALUES " +
            "<foreach collection='list' item='item' separator=',' > " +
            "(#{item.startTime}, #{item.endTime}, #{item.personId}, #{item.districtId}, " +
            "#{item.pitId}, #{item.carrotId}, #{item.remark}, #{item.summary}, " +
            "#{item.priority}, #{item.pid}, #{item.type}, #{item.ranking}, #{item.enabled})" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertMany(List<ProfilePO> profiles);

    // TODO: 存在设置某个属性为null不成功的情况
    @Update("<script> " +
            "UPDATE profile" +
            "<trim prefix='set' suffixOverrides=',' suffix=' where id = #{id}'>" +
            "<if test='startTime != null'> start_time=#{startTime}, </if>" +
            "<if test='endTime != null'> end_time=#{endTime}, </if>" +
            "<if test='personId != null'> person_id=#{personId}, </if>" +
            "<if test='districtId != null'> district_id=#{districtId}, </if>" +
            "<if test='pitId != null'> pit_id=#{pitId}, </if>" +
            "<if test='carrotId != null'> carrot_id=#{carrotId}, </if>" +
            "<if test='remark != null'> remark=#{remark}, </if>" +
            "<if test='summary != null'> summary=#{summary}, </if>" +
            "<if test='priority != null'> priority=#{priority}, </if>" +
            "<if test='pid != null'> pid=#{pid}, </if>" +
            "<if test='type != null'> type=#{type}, </if>" +
            "<if test='ranking != null'> ranking=#{ranking}, </if>" +
            "<if test='enabled != null'> is_enabled=#{enabled}, </if>" +
            "<if test='deleted != null'> is_deleted=#{deleted}, </if>" +
            "</trim>" +
            "</script>")
    int updateOne(ProfilePO profile);

    @Insert("<script> INSERT INTO profile " +
            "(id, start_time, end_time, person_id, district_id, " +
            "pit_id, carrot_id, remark, summary, " +
            "priority, pid, type, ranking, is_enabled) " +
            "VALUES " +
            "<foreach collection='list' item='item' separator=',' > " +
            "(#{item.id}, #{item.startTime}, #{item.endTime}, #{item.personId}, #{item.districtId}, " +
            "#{item.pitId}, #{item.carrotId}, #{item.remark}, #{item.summary}, " +
            "#{item.priority}, #{item.pid}, #{item.type}, #{item.ranking}, #{item.enabled}) " +
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
            "pid = VALUES(pid)," +
            "type = VALUES(type)," +
            "ranking = VALUES(ranking)," +
            "is_enabled = VALUES(is_enabled)" +
            "</script>")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int updateMany(List<ProfilePO> profiles);

    @Delete("Delete FROM profile WHERE ${field} = #{value}")
    int deleteOne(String field, long value);

}

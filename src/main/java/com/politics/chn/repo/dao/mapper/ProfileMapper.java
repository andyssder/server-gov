package com.politics.chn.repo.dao.mapper;

import com.politics.chn.model.domain.entity.ProfileDO;
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
            "remark, summary, priority, is_deleted) " +
            "VALUES(" +
            "#{startTime}, #{endTime}, #{personId}, " +
            "#{district}, #{pit}, #{carrot}, " +
            "#{remark}, #{summary}, #{priority}, #{deleted})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(ProfileDO profile);

    @Insert("<script> INSERT INTO profile " +
            "(start_time, end_time, person_id, district_id, pit_id, carrot_id, remark, summary, priority, is_deleted) " +
            "VALUES " +
            "<foreach collection='list' item='item' separator=',' > " +
            "(#{item.startTime}, #{item.endTime}, #{item.personId}, " +
            "#{item.district}, #{item.pit}, #{item.carrot}, " +
            "#{item.remark}, #{item.summary}, #{item.priority}, #{item.deleted}) " +
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

    @Update("<script>" +
            "UPDATE profile" +
            "<set>" +
            "<trim prefix='start_time=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.startTime != null'>" +
            "when id=#{item.id} then #{item.startTime} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='start_time=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.startTime != null'>" +
            "when id=#{item.id} then #{item.startTime} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='end_time=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.endTime != null'>" +
            "when id=#{item.id} then #{item.endTime} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='person_id=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.personId != null'>" +
            "when id=#{item.id} then #{item.personId} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='district_id=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.district != null'>" +
            "when id=#{item.id} then #{item.district} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='pit_id=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.pit != null'>" +
            "when id=#{item.id} then #{item.pit} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='carrot_id=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.carrot != null'>" +
            "when id=#{item.id} then #{item.carrot} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='remark=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.remark != null'>" +
            "when id=#{item.id} then #{item.remark} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='summary=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.summary != null'>" +
            "when id=#{item.id} then #{item.summary} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='priority=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.priority != null'>" +
            "when id=#{item.id} then #{item.priority} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='is_enabled=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.enabled != null'>" +
            "when id=#{item.id} then #{item.enabled} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "<trim prefix='is_deleted=case' suffix='end,'>" +
            "<foreach collection='list' item='item' index='index'>" +
            "<if test='item.deleted != null'>" +
            "when id=#{item.id} then #{item.deleted} " +
            "</if>" +
            "</foreach>" +
            "</trim>" +
            "</set>" +
            "where id in" +
            "<foreach collection='list' item='item' index='index' separator=',' open='(' close=')'>" +
            " #{item.id}" +
            "</foreach>" +
            "</script>")
    int updateMany(List<ProfileDO> profiles);

    @Update("UPDATE profile SET is_deleted = true WHERE ${field} = #{value}")
    int deleteOne(String field, long value);

    @Delete("Delete FROM profile WHERE ${field} = #{value}")
    int realDeleteOne(String field, long value);

}

package com.politics.chn.repo.dao.mapper;

import com.politics.chn.model.domain.entity.ProfileDO;
import com.politics.chn.model.po.ProfilePO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-19 21:34
 */
@Mapper
public interface ProfileMapper {
    @Select("SELECT * FROM profile")
    @Results(id="profile", value={
            @Result(property="district",column="district_id",one=@One(select="com.politics.chn.repo.dao.mapper.DistrictMapper.getOneById")),
            @Result(property="pit",column="pit_id",one=@One(select="com.politics.chn.repo.dao.mapper.PitMapper.getOneById")),
            @Result(property="carrot",column="carrot_id",one=@One(select="com.politics.chn.repo.dao.mapper.CarrotMapper.getOneById"))
    })
    List<ProfileDO> getAll();

    @Select("SELECT * FROM profile WHERE person_id = #{personId}")
    @ResultMap("profile")
    List<ProfileDO> getByPersonId(long personId);

    @Select("SELECT * FROM profile WHERE id = #{id}")
    @ResultMap("profile")
    ProfileDO getOneById(long id);

    @Insert("INSERT INTO profile(" +
            "start_time, end_time, person_id," +
            "district_id, pit_id, carrot_id" +
            "remark, summary, priority, is_deleted) " +
            "VALUES(" +
            "#{startTime}, #{endTime}, #{personId}," +
            "#{districtId}, #{pitId}, #{carrotId}," +
            "#{remark}, #{summary}, #{priority}, #{isDeleted})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(ProfilePO profilePO);

    @Insert("<script> INSERT INTO profile " +
            "(start_time, end_time, person_id, start_time, end_time, person_id, remark, summary, priority, is_deleted) " +
            "VALUES " +
            "<foreach collection='profiles' item='item' separator=',' > " +
            "(#{item.startTime}, #{item.endTime}, #{item.personId}, " +
            "#{item.districtId}, #{item.pitId}, #{item.carrotId}" +
            "#{item.remark}, #{item.summary}, #{item.priority}, #{item.isDeleted}) " +
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
            "<if test='isDeleted != null'> is_deleted=#{isDeleted}, </if>" +
            "</trim>" +
            "</script>")
    int updateOne(ProfilePO profilePO);

    @Update({"<script> UPDATE profile " +
            "<foreach  collection = 'profiles' item = 'item' index = 'index' open = '(' separator= ',' close = ')' >" +
            "<trim prefix='set' suffixOverrides=',' suffix=' where id = #{id}'>" +
            "<if test='item.startTime != null'> start_time=#{item.startTime}, </if>" +
            "<if test='item.endTime != null'> end_time=#{item.endTime}, </if>" +
            "<if test='item.personId != null'> person_id=#{item.personId}, </if>" +
            "<if test='item.districtId != null'> district_id=#{item.districtId}, </if>" +
            "<if test='item.pitId != null'> pit_id=#{item.pitId}, </if>" +
            "<if test='item.carrotId != null'> carrot_id=#{item.carrotId}, </if>" +
            "<if test='item.remark != null'> remark=#{item.remark}, </if>" +
            "<if test='item.summary != null'> summary=#{item.summary}, </if>" +
            "<if test='item.priority != null'> priority=#{item.priority}, </if>" +
            "<if test='item.isDeleted != null'> is_deleted=#{item.isDeleted}, </if>" +
            "</trim>" +
            "</foreach>" +
            "</script>"})
    int updateMany(List<ProfilePO> profiles);

    @Update("UPDATE profile SET is_deleted = true WHERE ${field} = #{value}")
    int deleteOne(String field, long value);

    @Delete("Delete FROM profile WHERE ${field} = #{value}")
    int realDeleteOne(String field, long value);

}

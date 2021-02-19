package com.politics.chn.repo.dao.mapper;

import com.politics.chn.model.domain.entity.ProfileDO;
import com.politics.chn.model.po.ProfilePO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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

    @Select("SELECT * FROM profile WHERE id = #{id}")
    @ResultMap("profile")
    ProfileDO getOneById(long id);

    @Insert("INSERT INTO profile(" +
            "start_time, end_time, person_id," +
            "district_id, pit_id, carrot_id" +
            "remark, summary, is_delete)" +
            " VALUES(" +
            "#{startTime}, #{endTime}, #{personId}," +
            "#{districtId}, #{pitId}, #{carrotId}," +
            "#{remark}, #{summary}, #{isDelete})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(ProfilePO profilePO);

    @Update("<script> " +
            "UPDATE profile SET" +
            "<foreach item='value' index='key' collection='updateParams.entrySet()' separator=','>" +
            "${key} = #{value}" +
            "</foreach>" +
            "WHERE id = #{id}" +
            "</script>")
    int updateOne(long id, Map<String, Object> updateParams);

    @Update("UPDATE profile SET is_deleted = true WHERE ${field} = #{value}")
    int deleteOne(String field, long value);

    @Delete("Delete FROM profile WHERE ${field} = #{value}")
    int realDeleteOne(String field, long value);

}

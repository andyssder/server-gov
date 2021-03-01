package com.politics.chn.repo.dao.mapper;

import com.politics.chn.model.domain.aggregate.OfficialDO;
import com.politics.chn.model.domain.entity.PersonDO;
import com.politics.chn.model.po.PersonPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-18 17:41
 */
@Mapper
public interface PersonMapper {

    @Select("SELECT * FROM person where is_deleted = false")
    @Results(id="official", value={
            @Result(property="person",column="id",one=@One(select="com.politics.chn.repo.dao.mapper.PersonMapper.getOnePersonById")),
            @Result(property = "profiles", javaType = List.class, column = "id",
                    many = @Many(select = "com.politics.chn.repo.dao.mapper.ProfileMapper.getByPersonId"))
    })
    List<OfficialDO> getAll();

    @Select("SELECT * FROM person WHERE id = #{id} and is_deleted = false")
    @ResultMap("official")
    OfficialDO getOneById(long id);

    @Select("SELECT * FROM person")
    @Results(id="person", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted"),
            @Result(property="party",column="party_id",one=@One(select="com.politics.chn.repo.dao.mapper.PartyMapper.getOneById")),
            @Result(property="ethnicity",column="ethnicity_id",one=@One(select="com.politics.chn.repo.dao.mapper.EthnicityMapper.getOneById")),
            @Result(property="ancestralHome",column="ancestral_home",one=@One(select="com.politics.chn.repo.dao.mapper.DistrictMapper.getOneById")),
            @Result(property="birthPlace",column="birth_place",one=@One(select="com.politics.chn.repo.dao.mapper.DistrictMapper.getOneById")),
            @Result(property="workPlace",column="work_place",one=@One(select="com.politics.chn.repo.dao.mapper.DistrictMapper.getOneById"))
    })
    List<PersonDO> getAllPerson();

    @Select("SELECT * FROM person WHERE id = #{id}")
    @ResultMap("person")
    OfficialDO getOnePersonById(long id);

    @Insert("INSERT INTO person(" +
            "name, portrait, gender, ethnicity_id, " +
            "birth_date, death_date, work_date, retire_date, " +
            "ancestral_home, birth_place, work_place, " +
            "university, major, education, degree, " +
            "rank, create_time, update_time, is_enabled, is_deleted) " +
            "VALUES(" +
            "#{name}, #{portrait}, #{gender}, #{ethnicityId}, " +
            "#{birthDate}, #{deathDate}, #{workDate}, #{retireDate}, " +
            "#{ancestralHome}, #{birthPlace}, #{workPlace}," +
            "#{university}, #{major}, #{education}, #{degree}," +
            "#{rank}, #{createTime}, #{updateTime}, #{enabled}, #{deleted})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(PersonPO personPO);

    // TODO: 存在设置某个属性为null不成功的情况
    @Update("<script> " +
            "UPDATE person" +
            "<trim prefix='set' suffixOverrides=',' suffix=' where id = #{id}'>" +
            "<if test='name != null'> name=#{name}, </if>" +
            "<if test='portrait != null'> portrait=#{portrait}, </if>" +
            "<if test='gender != null'> gender=#{gender}, </if>" +
            "<if test='ethnicityId != null'> ethnicityId=#{ethnicityId}, </if>" +
            "<if test='birthDate != null'> birth_date=#{birthDate}, </if>" +
            "<if test='deathDate != null'> death_date=#{deathDate}, </if>" +
            "<if test='workDate != null'> work_date=#{workDate}, </if>" +
            "<if test='retireDate != null'> retire_date=#{retireDate}, </if>" +
            "<if test='ancestralHome != null'> ancestral_home=#{ancestralHome}, </if>" +
            "<if test='birthPlace != null'> birth_place=#{birthPlace}, </if>" +
            "<if test='workPlace != null'> work_place=#{workPlace}, </if>" +
            "<if test='university != null'> university=#{university}, </if>" +
            "<if test='major != null'> major=#{major}, </if>" +
            "<if test='education != null'> education=#{education}, </if>" +
            "<if test='major != null'> major=#{major}, </if>" +
            "<if test='degree != null'> degree=#{degree}, </if>" +
            "<if test='rank != null'> rank=#{rank}, </if>" +
            "<if test='createTime != null'> create_time=#{createTime}, </if>" +
            "<if test='updateTime != null'> update_time=#{updateTime}, </if>" +
            "<if test='enabled != null'> is_enabled=#{enabled}, </if>" +
            "<if test='deleted != null'> is_deleted=#{deleted}, </if>" +
            "</trim>" +
            "</script>")
    int updateOne(PersonPO personPO);

    @Update("UPDATE person SET is_deleted = true WHERE id = #{id}")
    int deleteOne(long id);

    @Delete("Delete FROM person WHERE id = #{id}")
    int realDeleteOne(long id);
}

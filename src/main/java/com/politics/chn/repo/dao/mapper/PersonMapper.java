package com.politics.chn.repo.dao.mapper;

import com.politics.chn.domain.official.entity.PersonDO;
import com.politics.chn.domain.official.value.DistrictDO;
import com.politics.chn.repo.po.PersonPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @since 2021-02-18
 * @author andyssder
 */
@Mapper
public interface PersonMapper {

    @Select("SELECT * FROM person WHERE is_deleted = false")
    @Results(id="person", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted"),
            @Result(property="party",column="party_id"),
            @Result(property="ethnicity",column="ethnicity_id"),
            @Result(property = "ancestralHome", javaType = DistrictDO.class, column = "ancestral_home",
                    one = @One(select = "com.politics.chn.repo.dao.mapper.DistrictMapper.getOneById")),
            @Result(property = "birthPlace", javaType = DistrictDO.class, column = "birth_place",
                    one = @One(select = "com.politics.chn.repo.dao.mapper.DistrictMapper.getOneById")),
            @Result(property = "workPlace", javaType = DistrictDO.class, column = "work_place",
                    one = @One(select = "com.politics.chn.repo.dao.mapper.DistrictMapper.getOneById")),
    })
    List<PersonDO> getAll();

    @Select("SELECT * FROM person WHERE id = #{id} LIMIT 1")
    @Results(id="onePerson", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted"),
            @Result(property="party",column="party_id"),
            @Result(property="ethnicity",column="ethnicity_id"),
            @Result(property = "ancestralHome", javaType = DistrictDO.class, column = "ancestral_home",
                    one = @One(select = "com.politics.chn.repo.dao.mapper.DistrictMapper.getOneByIdWithParents")),
            @Result(property = "birthPlace", javaType = DistrictDO.class, column = "birth_place",
                    one = @One(select = "com.politics.chn.repo.dao.mapper.DistrictMapper.getOneByIdWithParents")),
            @Result(property = "workPlace", javaType = DistrictDO.class, column = "work_place",
                    one = @One(select = "com.politics.chn.repo.dao.mapper.DistrictMapper.getOneByIdWithParents")),
    })
    PersonDO getOneById(long id);

    @Insert("INSERT INTO person(" +
            "name, portrait, gender, party_id, ethnicity_id, " +
            "birth_date, death_date, work_date, party_date, retire_date, " +
            "ancestral_home, birth_place, work_place, " +
            "university, major, education, degree, " +
            "ranking, create_time, update_time, is_enabled) " +
            "VALUES(" +
            "#{name}, #{portrait}, #{gender}, #{party}, #{ethnicity}, " +
            "#{birthDate}, #{deathDate}, #{workDate}, #{partyDate}, #{retireDate}, " +
            "#{ancestralHome}, #{birthPlace}, #{workPlace}," +
            "#{university}, #{major}, #{education}, #{degree}," +
            "#{ranking}, #{createTime}, #{updateTime}, #{enabled})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(PersonPO person);

    // TODO: 存在设置某个属性为null不成功的情况
    @Update("<script> " +
            "UPDATE person" +
            "<trim prefix='set' suffixOverrides=',' suffix=' WHERE id = #{id}'>" +
            "<if test='name != null'> name=#{name}, </if>" +
            "<if test='portrait != null'> portrait=#{portrait}, </if>" +
            "<if test='gender != null'> gender=#{gender}, </if>" +
            "<if test='ethnicity != null'> ethnicity_id=#{ethnicity}, </if>" +
            "<if test='party != null'> party_id=#{party}, </if>" +
            "<if test='birthDate != null'> birth_date=#{birthDate}, </if>" +
            "<if test='deathDate != null'> death_date=#{deathDate}, </if>" +
            "<if test='workDate != null'> work_date=#{workDate}, </if>" +
            "<if test='partyDate != null'> party_date=#{partyDate}, </if>" +
            "<if test='retireDate != null'> retire_date=#{retireDate}, </if>" +
            "<if test='ancestralHome != null'> ancestral_home=#{ancestralHome}, </if>" +
            "<if test='birthPlace != null'> birth_place=#{birthPlace}, </if>" +
            "<if test='workPlace != null'> work_place=#{workPlace}, </if>" +
            "<if test='university != null'> university=#{university}, </if>" +
            "<if test='major != null'> major=#{major}, </if>" +
            "<if test='education != null'> education=#{education}, </if>" +
            "<if test='major != null'> major=#{major}, </if>" +
            "<if test='degree != null'> degree=#{degree}, </if>" +
            "<if test='ranking != null'> ranking=#{ranking}, </if>" +
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

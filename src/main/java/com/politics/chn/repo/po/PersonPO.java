package com.politics.chn.repo.po;

import com.politics.chn.domain.official.entity.PersonDO;
import com.politics.chn.domain.official.value.DistrictDO;

import java.util.Date;
import java.util.Objects;

/**
 * @author xu
 * @since 2021-04-27
 */
public class PersonPO {
    Long id;
    String name;
    String portrait;
    Integer gender;

    Integer party;
    Integer ethnicity;

    Date birthDate;

    Date deathDate;

    Date workDate;

    Date partyDate;

    Date retireDate;

    Integer ancestralHome;
    Integer birthPlace;
    Integer workPlace;

    String university;
    String major;
    String education;
    String degree;

    Integer ranking;

    Date createTime;
    Date updateTime;

    Boolean enabled;
    Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getParty() {
        return party;
    }

    public void setParty(Integer party) {
        this.party = party;
    }

    public Integer getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Integer ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Date getPartyDate() {
        return partyDate;
    }

    public void setPartyDate(Date partyDate) {
        this.partyDate = partyDate;
    }


    public Date getRetireDate() {
        return retireDate;
    }

    public void setRetireDate(Date retireDate) {
        this.retireDate = retireDate;
    }

    public Integer getAncestralHome() {
        return ancestralHome;
    }

    public void setAncestralHome(Integer ancestralHome) {
        this.ancestralHome = ancestralHome;
    }

    public Integer getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Integer birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Integer getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(Integer workPlace) {
        this.workPlace = workPlace;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonPO personPO = (PersonPO) o;
        return Objects.equals(id, personPO.id) && Objects.equals(name, personPO.name) && Objects.equals(portrait, personPO.portrait) && Objects.equals(gender, personPO.gender) && Objects.equals(party, personPO.party) && Objects.equals(ethnicity, personPO.ethnicity) && Objects.equals(birthDate, personPO.birthDate) && Objects.equals(deathDate, personPO.deathDate) && Objects.equals(workDate, personPO.workDate) && Objects.equals(partyDate, personPO.partyDate) && Objects.equals(retireDate, personPO.retireDate) && Objects.equals(ancestralHome, personPO.ancestralHome) && Objects.equals(birthPlace, personPO.birthPlace) && Objects.equals(workPlace, personPO.workPlace) && Objects.equals(university, personPO.university) && Objects.equals(major, personPO.major) && Objects.equals(education, personPO.education) && Objects.equals(degree, personPO.degree) && Objects.equals(ranking, personPO.ranking) && Objects.equals(createTime, personPO.createTime) && Objects.equals(updateTime, personPO.updateTime) && Objects.equals(enabled, personPO.enabled) && Objects.equals(deleted, personPO.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, portrait, gender, party, ethnicity, birthDate, deathDate, workDate, partyDate, retireDate, ancestralHome, birthPlace, workPlace, university, major, education, degree, ranking, createTime, updateTime, enabled, deleted);
    }

    @Override
    public String toString() {
        return "PersonPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", portrait='" + portrait + '\'' +
                ", gender=" + gender +
                ", party=" + party +
                ", ethnicity=" + ethnicity +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                ", workDate=" + workDate +
                ", partyDate=" + partyDate +
                ", retireDate=" + retireDate +
                ", ancestralHome=" + ancestralHome +
                ", birthPlace=" + birthPlace +
                ", workPlace=" + workPlace +
                ", university='" + university + '\'' +
                ", major='" + major + '\'' +
                ", education='" + education + '\'' +
                ", degree='" + degree + '\'' +
                ", ranking=" + ranking +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", enabled=" + enabled +
                ", deleted=" + deleted +
                '}';
    }
}

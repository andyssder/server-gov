package com.politics.chn.model.domain.entity;

import com.politics.chn.model.domain.value.DistrictDO;
import com.politics.chn.model.domain.value.EthnicityDO;
import com.politics.chn.model.domain.value.PartyDO;

import java.util.Date;
import java.util.Objects;

/**
 * @author andyssder
 * @create 2021-02-19 19:54
 */
public class PersonDO {
    Long id;
    String name;
    String portrait;
    Integer gender;

    PartyDO party;
    EthnicityDO ethnicity;

    Date birthDate;
    Date deathDate;
    Date workDate;
    Date retireDate;

    DistrictDO ancestralHome;
    DistrictDO birthPlace;
    DistrictDO workPlace;

    String university;
    String major;
    String education;
    String degree;

    Integer rank;

    Date creatTime;
    Date updateTime;

    Boolean isDeleted;

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

    public PartyDO getParty() {
        return party;
    }

    public void setParty(PartyDO party) {
        this.party = party;
    }

    public EthnicityDO getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(EthnicityDO ethnicity) {
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

    public Date getRetireDate() {
        return retireDate;
    }

    public void setRetireDate(Date retireDate) {
        this.retireDate = retireDate;
    }

    public DistrictDO getAncestralHome() {
        return ancestralHome;
    }

    public void setAncestralHome(DistrictDO ancestralHome) {
        this.ancestralHome = ancestralHome;
    }

    public DistrictDO getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(DistrictDO birthPlace) {
        this.birthPlace = birthPlace;
    }

    public DistrictDO getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(DistrictDO workPlace) {
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonDO personDO = (PersonDO) o;
        return Objects.equals(id, personDO.id) && Objects.equals(name, personDO.name) && Objects.equals(portrait, personDO.portrait) && Objects.equals(gender, personDO.gender) && Objects.equals(party, personDO.party) && Objects.equals(ethnicity, personDO.ethnicity) && Objects.equals(birthDate, personDO.birthDate) && Objects.equals(deathDate, personDO.deathDate) && Objects.equals(workDate, personDO.workDate) && Objects.equals(retireDate, personDO.retireDate) && Objects.equals(ancestralHome, personDO.ancestralHome) && Objects.equals(birthPlace, personDO.birthPlace) && Objects.equals(workPlace, personDO.workPlace) && Objects.equals(university, personDO.university) && Objects.equals(major, personDO.major) && Objects.equals(education, personDO.education) && Objects.equals(degree, personDO.degree) && Objects.equals(rank, personDO.rank) && Objects.equals(creatTime, personDO.creatTime) && Objects.equals(updateTime, personDO.updateTime) && Objects.equals(isDeleted, personDO.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, portrait, gender, party, ethnicity, birthDate, deathDate, workDate, retireDate, ancestralHome, birthPlace, workPlace, university, major, education, degree, rank, creatTime, updateTime, isDeleted);
    }

    @Override
    public String toString() {
        return "PersonDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", portrait='" + portrait + '\'' +
                ", gender=" + gender +
                ", party=" + party +
                ", ethnicity=" + ethnicity +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                ", workDate=" + workDate +
                ", retireDate=" + retireDate +
                ", ancestralHome=" + ancestralHome +
                ", birthPlace=" + birthPlace +
                ", workPlace=" + workPlace +
                ", university='" + university + '\'' +
                ", major='" + major + '\'' +
                ", education='" + education + '\'' +
                ", degree='" + degree + '\'' +
                ", rank=" + rank +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                ", isDeleted=" + isDeleted +
                '}';
    }
}

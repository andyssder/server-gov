package com.politics.chn.model.po;

import java.util.Date;
import java.util.Objects;

/**
 * @author: andyssder
 * @create: 2021-02-18 14:07
 */
public class PersonPO {
    Long id;
    String name;
    String portrait;
    Integer gender;

    PartyPO party;
    EthnicityPO ethnicity;

    Date birthDate;
    Date deathDate;
    Date workDate;
    Date retireDate;

    DistrictPO ancestralHome;
    DistrictPO birthPlace;
    DistrictPO workPlace;

    String university;
    String major;
    String education;
    String degree;

    Integer rank;

    Date creatTime;
    Date updateTime;

    public PersonPO() {
    }

    public PersonPO(String name, Integer gender, Date creatTime, Date updateTime) {
        this(null, name, null, gender, null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null, creatTime, updateTime);
    }

    public PersonPO(Long id, String name, String portrait, Integer gender, PartyPO party, EthnicityPO ethnicity,
                    Date birthDate, Date deathDate, Date workDate, Date retireDate,
                    DistrictPO ancestralHome, DistrictPO birthPlace, DistrictPO workPlace,
                    String university, String major, String education, String degree,
                    Integer rank, Date creatTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.portrait = portrait;
        this.gender = gender;
        this.party = party;
        this.ethnicity = ethnicity;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.workDate = workDate;
        this.retireDate = retireDate;
        this.ancestralHome = ancestralHome;
        this.birthPlace = birthPlace;
        this.workPlace = workPlace;
        this.university = university;
        this.major = major;
        this.education = education;
        this.degree = degree;
        this.rank = rank;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
    }

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

    public PartyPO getParty() {
        return party;
    }

    public void setParty(PartyPO party) {
        this.party = party;
    }

    public EthnicityPO getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(EthnicityPO ethnicity) {
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

    public DistrictPO getAncestralHome() {
        return ancestralHome;
    }

    public void setAncestralHome(DistrictPO ancestralHome) {
        this.ancestralHome = ancestralHome;
    }

    public DistrictPO getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(DistrictPO birthPlace) {
        this.birthPlace = birthPlace;
    }

    public DistrictPO getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(DistrictPO workPlace) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonPO personPO = (PersonPO) o;
        return Objects.equals(id, personPO.id) && Objects.equals(name, personPO.name) && Objects.equals(portrait, personPO.portrait) && Objects.equals(gender, personPO.gender) && Objects.equals(party, personPO.party) && Objects.equals(ethnicity, personPO.ethnicity) && Objects.equals(birthDate, personPO.birthDate) && Objects.equals(deathDate, personPO.deathDate) && Objects.equals(workDate, personPO.workDate) && Objects.equals(retireDate, personPO.retireDate) && Objects.equals(ancestralHome, personPO.ancestralHome) && Objects.equals(birthPlace, personPO.birthPlace) && Objects.equals(workPlace, personPO.workPlace) && Objects.equals(university, personPO.university) && Objects.equals(major, personPO.major) && Objects.equals(education, personPO.education) && Objects.equals(degree, personPO.degree) && Objects.equals(rank, personPO.rank) && Objects.equals(creatTime, personPO.creatTime) && Objects.equals(updateTime, personPO.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, portrait, gender, party, ethnicity, birthDate, deathDate, workDate, retireDate, ancestralHome, birthPlace, workPlace, university, major, education, degree, rank, creatTime, updateTime);
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
                '}';
    }
}

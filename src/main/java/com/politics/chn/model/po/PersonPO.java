package com.politics.chn.model.po;

import java.util.Date;
import java.util.Objects;

/**
 * @author andyssder
 * @create 2021-02-18 14:07
 */
public class PersonPO {
    Long id;
    String name;
    String portrait;
    Integer gender;

    Integer partyId;
    Integer ethnicityId;

    Date birthDate;
    Date deathDate;
    Date workDate;
    Date retireDate;

    Integer ancestralHome;
    Integer birthPlace;
    Integer workPlace;

    String university;
    String major;
    String education;
    String degree;

    Integer rank;

    Date createTime;
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

    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    public Integer getEthnicityId() {
        return ethnicityId;
    }

    public void setEthnicityId(Integer ethnicityId) {
        this.ethnicityId = ethnicityId;
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean delete) {
        isDeleted = delete;
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
        return Objects.equals(id, personPO.id) && Objects.equals(name, personPO.name) && Objects.equals(portrait, personPO.portrait) && Objects.equals(gender, personPO.gender) && Objects.equals(partyId, personPO.partyId) && Objects.equals(ethnicityId, personPO.ethnicityId) && Objects.equals(birthDate, personPO.birthDate) && Objects.equals(deathDate, personPO.deathDate) && Objects.equals(workDate, personPO.workDate) && Objects.equals(retireDate, personPO.retireDate) && Objects.equals(ancestralHome, personPO.ancestralHome) && Objects.equals(birthPlace, personPO.birthPlace) && Objects.equals(workPlace, personPO.workPlace) && Objects.equals(university, personPO.university) && Objects.equals(major, personPO.major) && Objects.equals(education, personPO.education) && Objects.equals(degree, personPO.degree) && Objects.equals(rank, personPO.rank) && Objects.equals(createTime, personPO.createTime) && Objects.equals(updateTime, personPO.updateTime) && Objects.equals(isDeleted, personPO.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, portrait, gender, partyId, ethnicityId, birthDate, deathDate, workDate, retireDate, ancestralHome, birthPlace, workPlace, university, major, education, degree, rank, createTime, updateTime, isDeleted);
    }

    @Override
    public String toString() {
        return "PersonPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", portrait='" + portrait + '\'' +
                ", gender=" + gender +
                ", partyId=" + partyId +
                ", ethnicityId=" + ethnicityId +
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
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDeleted=" + isDeleted +
                '}';
    }
}

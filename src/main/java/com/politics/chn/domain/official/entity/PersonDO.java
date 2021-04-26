package com.politics.chn.domain.official.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

/**
 * @since 2021-02-19
 * @author andyssder
 */
public class PersonDO {
    Long id;
    String name;
    String portrait;
    Integer gender;

    Integer party;
    Integer ethnicity;

    @DateTimeFormat(pattern = "yyyy-MM")
    @JsonFormat(pattern="yyyy-MM")
    Date birthDate;

    @DateTimeFormat(pattern = "yyyy-MM")
    @JsonFormat(pattern="yyyy-MM")
    Date deathDate;

    @DateTimeFormat(pattern = "yyyy-MM")
    @JsonFormat(pattern="yyyy-MM")
    Date workDate;

    @DateTimeFormat(pattern = "yyyy-MM")
    @JsonFormat(pattern="yyyy-MM")
    Date partyDate;

    @DateTimeFormat(pattern = "yyyy-MM")
    @JsonFormat(pattern="yyyy-MM")
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
        PersonDO personDO = (PersonDO) o;
        return Objects.equals(id, personDO.id) && Objects.equals(name, personDO.name) && Objects.equals(portrait, personDO.portrait) && Objects.equals(gender, personDO.gender) && Objects.equals(party, personDO.party) && Objects.equals(ethnicity, personDO.ethnicity) && Objects.equals(birthDate, personDO.birthDate) && Objects.equals(deathDate, personDO.deathDate) && Objects.equals(workDate, personDO.workDate) && Objects.equals(partyDate, personDO.partyDate) && Objects.equals(retireDate, personDO.retireDate) && Objects.equals(ancestralHome, personDO.ancestralHome) && Objects.equals(birthPlace, personDO.birthPlace) && Objects.equals(workPlace, personDO.workPlace) && Objects.equals(university, personDO.university) && Objects.equals(major, personDO.major) && Objects.equals(education, personDO.education) && Objects.equals(degree, personDO.degree) && Objects.equals(ranking, personDO.ranking) && Objects.equals(createTime, personDO.createTime) && Objects.equals(updateTime, personDO.updateTime) && Objects.equals(enabled, personDO.enabled) && Objects.equals(deleted, personDO.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, portrait, gender, party, ethnicity, birthDate, deathDate, workDate, partyDate, retireDate, ancestralHome, birthPlace, workPlace, university, major, education, degree, ranking, createTime, updateTime, enabled, deleted);
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

    public Boolean isNotNull() {
        return name != null && gender != null;
    }
}

package com.politics.chn.application.dto;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author andyssder
 * @since 2022-05-28
 */
public class OfficialDTO {

    Long id;

    String name;

    String portrait;

    Integer gender;

    Integer partyId;
    String partyName;

    Integer ethnicityId;
    String ethnicityName;

    Date birthDate;

    Date deathDate;

    Date workDate;

    Date partyDate;

    Date retireDate;

    Integer ancestralHomeId;
    String ancestralHomeName;
    List<Integer> ancestralHomePath;

    Integer birthPlaceId;
    String birthPlaceName;
    List<Integer> birthPlacePath;

    Integer workPlaceId;
    String workPlaceName;
    List<Integer> workPlacePath;

    String university;
    String major;
    String education;
    String degree;

    Integer ranking;

    Date createTime;
    Date updateTime;

    Boolean enabled;

    List<ProfileDTO> profiles;

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

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Integer getEthnicityId() {
        return ethnicityId;
    }

    public void setEthnicityId(Integer ethnicityId) {
        this.ethnicityId = ethnicityId;
    }

    public String getEthnicityName() {
        return ethnicityName;
    }

    public void setEthnicityName(String ethnicityName) {
        this.ethnicityName = ethnicityName;
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

    public Integer getAncestralHomeId() {
        return ancestralHomeId;
    }

    public void setAncestralHomeId(Integer ancestralHomeId) {
        this.ancestralHomeId = ancestralHomeId;
    }

    public String getAncestralHomeName() {
        return ancestralHomeName;
    }

    public void setAncestralHomeName(String ancestralHomeName) {
        this.ancestralHomeName = ancestralHomeName;
    }

    public Integer getBirthPlaceId() {
        return birthPlaceId;
    }

    public void setBirthPlaceId(Integer birthPlaceId) {
        this.birthPlaceId = birthPlaceId;
    }

    public String getBirthPlaceName() {
        return birthPlaceName;
    }

    public void setBirthPlaceName(String birthPlaceName) {
        this.birthPlaceName = birthPlaceName;
    }

    public Integer getWorkPlaceId() {
        return workPlaceId;
    }

    public void setWorkPlaceId(Integer workPlaceId) {
        this.workPlaceId = workPlaceId;
    }

    public String getWorkPlaceName() {
        return workPlaceName;
    }

    public void setWorkPlaceName(String workPlaceName) {
        this.workPlaceName = workPlaceName;
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

    public List<ProfileDTO> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileDTO> profiles) {
        this.profiles = profiles;
    }

    public List<Integer> getAncestralHomePath() {
        return ancestralHomePath;
    }

    public void setAncestralHomePath(List<Integer> ancestralHomePath) {
        this.ancestralHomePath = ancestralHomePath;
    }

    public List<Integer> getBirthPlacePath() {
        return birthPlacePath;
    }

    public void setBirthPlacePath(List<Integer> birthPlacePath) {
        this.birthPlacePath = birthPlacePath;
    }

    public List<Integer> getWorkPlacePath() {
        return workPlacePath;
    }

    public void setWorkPlacePath(List<Integer> workPlacePath) {
        this.workPlacePath = workPlacePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfficialDTO that = (OfficialDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(portrait, that.portrait) && Objects.equals(gender, that.gender) && Objects.equals(partyId, that.partyId) && Objects.equals(partyName, that.partyName) && Objects.equals(ethnicityId, that.ethnicityId) && Objects.equals(ethnicityName, that.ethnicityName) && Objects.equals(birthDate, that.birthDate) && Objects.equals(deathDate, that.deathDate) && Objects.equals(workDate, that.workDate) && Objects.equals(partyDate, that.partyDate) && Objects.equals(retireDate, that.retireDate) && Objects.equals(ancestralHomeId, that.ancestralHomeId) && Objects.equals(ancestralHomeName, that.ancestralHomeName) && Objects.equals(ancestralHomePath, that.ancestralHomePath) && Objects.equals(birthPlaceId, that.birthPlaceId) && Objects.equals(birthPlaceName, that.birthPlaceName) && Objects.equals(birthPlacePath, that.birthPlacePath) && Objects.equals(workPlaceId, that.workPlaceId) && Objects.equals(workPlaceName, that.workPlaceName) && Objects.equals(workPlacePath, that.workPlacePath) && Objects.equals(university, that.university) && Objects.equals(major, that.major) && Objects.equals(education, that.education) && Objects.equals(degree, that.degree) && Objects.equals(ranking, that.ranking) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(enabled, that.enabled) && Objects.equals(profiles, that.profiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, portrait, gender, partyId, partyName, ethnicityId, ethnicityName, birthDate, deathDate, workDate, partyDate, retireDate, ancestralHomeId, ancestralHomeName, ancestralHomePath, birthPlaceId, birthPlaceName, birthPlacePath, workPlaceId, workPlaceName, workPlacePath, university, major, education, degree, ranking, createTime, updateTime, enabled, profiles);
    }

    @Override
    public String toString() {
        return "OfficialDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", portrait='" + portrait + '\'' +
                ", gender=" + gender +
                ", partyId=" + partyId +
                ", partyName='" + partyName + '\'' +
                ", ethnicityId=" + ethnicityId +
                ", ethnicityName='" + ethnicityName + '\'' +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                ", workDate=" + workDate +
                ", partyDate=" + partyDate +
                ", retireDate=" + retireDate +
                ", ancestralHomeId=" + ancestralHomeId +
                ", ancestralHomeName='" + ancestralHomeName + '\'' +
                ", ancestralHomePath=" + ancestralHomePath +
                ", birthPlaceId=" + birthPlaceId +
                ", birthPlaceName='" + birthPlaceName + '\'' +
                ", birthPlacePath=" + birthPlacePath +
                ", workPlaceId=" + workPlaceId +
                ", workPlaceName='" + workPlaceName + '\'' +
                ", workPlacePath=" + workPlacePath +
                ", university='" + university + '\'' +
                ", major='" + major + '\'' +
                ", education='" + education + '\'' +
                ", degree='" + degree + '\'' +
                ", ranking=" + ranking +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", enabled=" + enabled +
                ", profiles=" + profiles +
                '}';
    }
}

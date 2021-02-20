package com.politics.chn.model.po;

import java.util.Date;
import java.util.Objects;

/**
 * @author andyssder
 * @create 2021-02-18 14:00
 */
public class ProfilePO {
    Long id;
    Date startTime;
    Date endTime;
    Long personId;
    Integer districtId;
    Integer pitId;
    Integer carrotId;
    String remark;
    String summary;
    Boolean isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getPitId() {
        return pitId;
    }

    public void setPitId(Integer pitId) {
        this.pitId = pitId;
    }

    public Integer getCarrotId() {
        return carrotId;
    }

    public void setCarrotId(Integer carrotId) {
        this.carrotId = carrotId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProfilePO profilePO = (ProfilePO) o;
        return Objects.equals(id, profilePO.id) && Objects.equals(startTime, profilePO.startTime) && Objects.equals(endTime, profilePO.endTime) && Objects.equals(personId, profilePO.personId) && Objects.equals(districtId, profilePO.districtId) && Objects.equals(pitId, profilePO.pitId) && Objects.equals(carrotId, profilePO.carrotId) && Objects.equals(remark, profilePO.remark) && Objects.equals(summary, profilePO.summary) && Objects.equals(isDelete, profilePO.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, endTime, personId, districtId, pitId, carrotId, remark, summary, isDelete);
    }

    @Override
    public String toString() {
        return "ProfilePO{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", personId=" + personId +
                ", districtId=" + districtId +
                ", pitId=" + pitId +
                ", carrotId=" + carrotId +
                ", remark='" + remark + '\'' +
                ", summary='" + summary + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}

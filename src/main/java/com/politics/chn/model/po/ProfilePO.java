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
    Long pitId;
    Long carrotId;
    String remark;
    String summary;
    Integer priority;

    Boolean deleted;

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

    public Long getPitId() {
        return pitId;
    }

    public void setPitId(Long pitId) {
        this.pitId = pitId;
    }

    public Long getCarrotId() {
        return carrotId;
    }

    public void setCarrotId(Long carrotId) {
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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
        ProfilePO profilePO = (ProfilePO) o;
        return Objects.equals(id, profilePO.id) && Objects.equals(startTime, profilePO.startTime) && Objects.equals(endTime, profilePO.endTime) && Objects.equals(personId, profilePO.personId) && Objects.equals(districtId, profilePO.districtId) && Objects.equals(pitId, profilePO.pitId) && Objects.equals(carrotId, profilePO.carrotId) && Objects.equals(remark, profilePO.remark) && Objects.equals(summary, profilePO.summary) && Objects.equals(priority, profilePO.priority) && Objects.equals(deleted, profilePO.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, endTime, personId, districtId, pitId, carrotId, remark, summary, priority, deleted);
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
                ", priority=" + priority +
                ", deleted=" + deleted +
                '}';
    }
}

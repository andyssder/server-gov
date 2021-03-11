package com.politics.chn.model.domain.entity;

import java.util.Date;
import java.util.Objects;

/**
 * @author andyssder
 * @create 2021-02-19 19:55
 */
public class ProfileDO {
    Long id;
    Date startTime;
    Date endTime;
    Long personId;
    Integer district;
    Long pit;
    Long carrot;
    String remark;
    String summary;
    Integer priority;

    Boolean enabled;
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

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public Long getPit() {
        return pit;
    }

    public void setPit(Long pit) {
        this.pit = pit;
    }

    public Long getCarrot() {
        return carrot;
    }

    public void setCarrot(Long carrot) {
        this.carrot = carrot;
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
        ProfileDO profileDO = (ProfileDO) o;
        return Objects.equals(id, profileDO.id) && Objects.equals(startTime, profileDO.startTime) && Objects.equals(endTime, profileDO.endTime) && Objects.equals(personId, profileDO.personId) && Objects.equals(district, profileDO.district) && Objects.equals(pit, profileDO.pit) && Objects.equals(carrot, profileDO.carrot) && Objects.equals(remark, profileDO.remark) && Objects.equals(summary, profileDO.summary) && Objects.equals(priority, profileDO.priority) && Objects.equals(enabled, profileDO.enabled) && Objects.equals(deleted, profileDO.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, endTime, personId, district, pit, carrot, remark, summary, priority, enabled, deleted);
    }

    @Override
    public String toString() {
        return "ProfileDO{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", personId=" + personId +
                ", district=" + district +
                ", pit=" + pit +
                ", carrot=" + carrot +
                ", remark='" + remark + '\'' +
                ", summary='" + summary + '\'' +
                ", priority=" + priority +
                ", enabled=" + enabled +
                ", deleted=" + deleted +
                '}';
    }

    public Boolean isNotNull() {
        return startTime != null && personId != null && district != null && pit != null && carrot != null;
    }
}

package com.politics.chn.application.dto;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author andyssder
 * @since 2022-05-28
 */
public class ProfileDTO {
    Long id;

    Date startTime;
    Date endTime;

    Integer district;
    String districtName;
    List<Integer> districtPath;

    Long pit;
    String pitName;
    List<Long> pitPath;

    Long carrot;
    String carrotName;

    String remark;
    String summary;
    Integer priority;

    Boolean enabled;

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

    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public List<Integer> getDistrictPath() {
        return districtPath;
    }

    public void setDistrictPath(List<Integer> districtPath) {
        this.districtPath = districtPath;
    }

    public Long getPit() {
        return pit;
    }

    public void setPit(Long pit) {
        this.pit = pit;
    }

    public String getPitName() {
        return pitName;
    }

    public void setPitName(String pitName) {
        this.pitName = pitName;
    }

    public List<Long> getPitPath() {
        return pitPath;
    }

    public void setPitPath(List<Long> pitPath) {
        this.pitPath = pitPath;
    }

    public Long getCarrot() {
        return carrot;
    }

    public void setCarrot(Long carrot) {
        this.carrot = carrot;
    }

    public String getCarrotName() {
        return carrotName;
    }

    public void setCarrotName(String carrotName) {
        this.carrotName = carrotName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileDTO that = (ProfileDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(district, that.district) && Objects.equals(districtName, that.districtName) && Objects.equals(districtPath, that.districtPath) && Objects.equals(pit, that.pit) && Objects.equals(pitName, that.pitName) && Objects.equals(pitPath, that.pitPath) && Objects.equals(carrot, that.carrot) && Objects.equals(carrotName, that.carrotName) && Objects.equals(remark, that.remark) && Objects.equals(summary, that.summary) && Objects.equals(priority, that.priority) && Objects.equals(enabled, that.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, endTime, district, districtName, districtPath, pit, pitName, pitPath, carrot, carrotName, remark, summary, priority, enabled);
    }

    @Override
    public String toString() {
        return "ProfileDTO{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", districtId=" + district +
                ", districtName='" + districtName + '\'' +
                ", districtPath=" + districtPath +
                ", pit=" + pit +
                ", pitName='" + pitName + '\'' +
                ", pitPath=" + pitPath +
                ", carrot=" + carrot +
                ", carrotName='" + carrotName + '\'' +
                ", remark='" + remark + '\'' +
                ", summary='" + summary + '\'' +
                ", priority=" + priority +
                ", enabled=" + enabled +
                '}';
    }
}

package com.politics.chn.model.po;

import java.util.Date;
import java.util.Objects;

/**
 * @author: andyssder
 * @create: 2021-02-18 14:00
 */
public class ProfilePO {
    Long id;
    Date startTime;
    Date endTime;
    Long personId;
    DistrictPO districtPO;
    PitPO pitPO;
    CarrotPO carrotPO;
    String remark;
    String summary;

    public ProfilePO() {
    }

    public ProfilePO(Date startTime, Long personID, DistrictPO districtPO, PitPO pitPO, CarrotPO carrotPO) {
        this(startTime, null, personID, districtPO, pitPO, carrotPO, null, null);
    }

    public ProfilePO(Date startTime, Date endTime, Long personID, DistrictPO districtPO, PitPO pitPO, CarrotPO carrotPO, String remark, String summary) {
        this(null, startTime, endTime, personID, districtPO, pitPO, carrotPO, remark, summary);
    }

    public ProfilePO(Long id, Date startTime, Date endTime, Long personId, DistrictPO districtPO, PitPO pitPO, CarrotPO carrotPO, String remark, String summary) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.personId = personId;
        this.districtPO = districtPO;
        this.pitPO = pitPO;
        this.carrotPO = carrotPO;
        this.remark = remark;
        this.summary = summary;
    }

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

    public DistrictPO getDistrictPO() {
        return districtPO;
    }

    public void setDistrictPO(DistrictPO districtPO) {
        this.districtPO = districtPO;
    }

    public PitPO getPitPO() {
        return pitPO;
    }

    public void setPitPO(PitPO pitPO) {
        this.pitPO = pitPO;
    }

    public CarrotPO getCarrotPO() {
        return carrotPO;
    }

    public void setCarrotPO(CarrotPO carrotPO) {
        this.carrotPO = carrotPO;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProfilePO profilePO = (ProfilePO) o;
        return Objects.equals(id, profilePO.id) && Objects.equals(startTime, profilePO.startTime) && Objects.equals(endTime, profilePO.endTime) && Objects.equals(personId, profilePO.personId) && Objects.equals(districtPO, profilePO.districtPO) && Objects.equals(pitPO, profilePO.pitPO) && Objects.equals(carrotPO, profilePO.carrotPO) && Objects.equals(remark, profilePO.remark) && Objects.equals(summary, profilePO.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, endTime, personId, districtPO, pitPO, carrotPO, remark, summary);
    }

    @Override
    public String toString() {
        return "ProfilePO{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", personID=" + personId +
                ", districtPO=" + districtPO +
                ", pitPO=" + pitPO +
                ", carrotPO=" + carrotPO +
                ", remark='" + remark + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}

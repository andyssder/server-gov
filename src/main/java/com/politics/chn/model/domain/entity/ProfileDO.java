package com.politics.chn.model.domain.entity;

import com.politics.chn.model.domain.value.CarrotDO;
import com.politics.chn.model.po.DistrictPO;
import com.politics.chn.model.po.PitPO;

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
    DistrictPO district;
    PitPO pit;
    CarrotDO carrot;
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

    public DistrictPO getDistrict() {
        return district;
    }

    public void setDistrict(DistrictPO district) {
        this.district = district;
    }

    public PitPO getPit() {
        return pit;
    }

    public void setPit(PitPO pit) {
        this.pit = pit;
    }

    public CarrotDO getCarrot() {
        return carrot;
    }

    public void setCarrot(CarrotDO carrot) {
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
        ProfileDO profileDO = (ProfileDO) o;
        return Objects.equals(id, profileDO.id) && Objects.equals(startTime, profileDO.startTime) && Objects.equals(endTime, profileDO.endTime) && Objects.equals(personId, profileDO.personId) && Objects.equals(district, profileDO.district) && Objects.equals(pit, profileDO.pit) && Objects.equals(carrot, profileDO.carrot) && Objects.equals(remark, profileDO.remark) && Objects.equals(summary, profileDO.summary) && Objects.equals(isDelete, profileDO.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, endTime, personId, district, pit, carrot, remark, summary, isDelete);
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
                ", isDelete=" + isDelete +
                '}';
    }
}

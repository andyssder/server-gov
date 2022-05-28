package com.politics.chn.domain.official.query;

import com.politics.chn.domain.common.Query;
import com.politics.chn.domain.official.entity.Pit;

/**
 * @author andyssder
 * @since 2021-12-02
 */
public class PitQuery implements Query<Pit> {
    Long pid;
    Integer level;
    Integer districtLevel;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getDistrictLevel() {
        return districtLevel;
    }

    public void setDistrictLevel(Integer districtLevel) {
        this.districtLevel = districtLevel;
    }
}

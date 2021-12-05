package com.politics.chn.domain.official.query;

import com.politics.chn.domain.common.Query;

/**
 * @author xu
 * @since 2021-12-02
 */
public class PitQuery implements Query {
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

package com.politics.chn.domain.official.query;

import com.politics.chn.domain.common.Query;
import com.politics.chn.domain.official.entity.District;

/**
 * @author andyssder
 * @since 2021-12-02
 */
public class DistrictQuery implements Query<District> {

    Integer level;

    Integer pid;

    Integer lft;

    Integer rgt;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}

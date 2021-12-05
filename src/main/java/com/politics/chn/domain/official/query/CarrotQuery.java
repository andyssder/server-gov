package com.politics.chn.domain.official.query;

import com.politics.chn.domain.common.Query;
import com.politics.chn.domain.official.entity.Carrot;

/**
 * @author xu
 * @since 2021-12-02
 */
public class CarrotQuery implements Query<Carrot> {

    Integer districtLevel;

    public Integer getDistrictLevel() {
        return districtLevel;
    }

    public void setDistrictLevel(Integer districtLevel) {
        this.districtLevel = districtLevel;
    }
}

package com.politics.chn.domain.official.entity;

import com.politics.chn.common.utils.StringUtils;

import java.util.Objects;

/**
 * @since 2021-02-19
 * @author andyssder
 */
public class CarrotDO {
    Long id;
    String name;
    String shortName;
    Integer districtLevel;

    Boolean enabled;

    public CarrotDO(Long id, String name, String shortName, Integer districtLevel, Boolean enabled) {
        assert StringUtils.isNotBlank(name);
        assert districtLevel >= 0;

        this.id = id;
        this.name = name;
        this.shortName = StringUtils.isNotBlank(shortName) ? shortName : "";
        this.districtLevel = districtLevel;
        this.enabled = Objects.nonNull(enabled) ? enabled : true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getDistrictLevel() {
        return districtLevel;
    }

    public void setDistrictLevel(Integer districtLevel) {
        this.districtLevel = districtLevel;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarrotDO carrotDO = (CarrotDO) o;
        return Objects.equals(id, carrotDO.id) && Objects.equals(name, carrotDO.name) && Objects.equals(shortName, carrotDO.shortName) && Objects.equals(districtLevel, carrotDO.districtLevel) && Objects.equals(enabled, carrotDO.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName, districtLevel, enabled);
    }

    @Override
    public String toString() {
        return "CarrotPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", districtLevel=" + districtLevel +
                ", enabled=" + enabled +
                '}';
    }
}
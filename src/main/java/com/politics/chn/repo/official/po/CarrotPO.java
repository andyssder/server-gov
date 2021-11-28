package com.politics.chn.repo.official.po;

import java.util.Objects;

/**
 * @since 2021-02-19
 * @author andyssder
 */
public class CarrotPO {
    Long id;
    String name;
    String shortName;
    Integer districtLevel;

    Boolean enabled;
    Boolean deleted;

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
        CarrotPO carrotPO = (CarrotPO) o;
        return Objects.equals(id, carrotPO.id) && Objects.equals(name, carrotPO.name) && Objects.equals(shortName, carrotPO.shortName) && Objects.equals(districtLevel, carrotPO.districtLevel) && Objects.equals(enabled, carrotPO.enabled) && Objects.equals(deleted, carrotPO.deleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName, districtLevel, enabled, deleted);
    }

    @Override
    public String toString() {
        return "CarrotPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", districtLevel=" + districtLevel +
                ", enabled=" + enabled +
                ", deleted=" + deleted +
                '}';
    }

    public Boolean isNotNull() {
        return name != null && districtLevel != null;
    }
}

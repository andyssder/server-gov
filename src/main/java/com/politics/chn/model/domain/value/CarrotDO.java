package com.politics.chn.model.domain.value;

import java.util.Objects;

/**
 * @author andyssder
 * @create 2021-02-19 20:04
 */
public class CarrotDO {
    Long id;
    String name;
    String shortName;
    Integer pitLevel;
    Boolean isDeleted;

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

    public Integer getPitLevel() {
        return pitLevel;
    }

    public void setPitLevel(Integer pitLevel) {
        this.pitLevel = pitLevel;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
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
        return Objects.equals(id, carrotDO.id) && Objects.equals(name, carrotDO.name) && Objects.equals(shortName, carrotDO.shortName) && Objects.equals(pitLevel, carrotDO.pitLevel) && Objects.equals(isDeleted, carrotDO.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName, pitLevel, isDeleted);
    }

    @Override
    public String toString() {
        return "CarrotDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", pitLevel=" + pitLevel +
                ", isDeleted=" + isDeleted +
                '}';
    }
}

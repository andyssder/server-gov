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
    Boolean isDelete;

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
        CarrotDO carrotDO = (CarrotDO) o;
        return Objects.equals(id, carrotDO.id) && Objects.equals(name, carrotDO.name) && Objects.equals(shortName, carrotDO.shortName) && Objects.equals(pitLevel, carrotDO.pitLevel) && Objects.equals(isDelete, carrotDO.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName, pitLevel, isDelete);
    }

    @Override
    public String toString() {
        return "CarrotDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", pitLevel=" + pitLevel +
                ", isDelete=" + isDelete +
                '}';
    }
}

package com.politics.chn.model.po;

import java.util.Objects;

/**
 * @author: andyssder
 * @create: 2021-02-18 10:51
 */
public class CarrotPO {
    Long id;
    String name;
    String shortName;
    Integer pitLevel;

    public CarrotPO() {
    }

    public CarrotPO(String name, Integer pitLevel) {
        this(name, null, pitLevel);
    }

    public CarrotPO(String name, String shortName, Integer pitLevel) {
        this(null, name, shortName, pitLevel);
    }

    public CarrotPO(Long id, String name, String shortName, Integer pitLevel) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.pitLevel = pitLevel;
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

    public Integer getPitLevel() {
        return pitLevel;
    }

    public void setPitLevel(Integer pitLevel) {
        this.pitLevel = pitLevel;
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
        return Objects.equals(id, carrotPO.id) && Objects.equals(name, carrotPO.name) && Objects.equals(shortName, carrotPO.shortName) && Objects.equals(pitLevel, carrotPO.pitLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName, pitLevel);
    }

    @Override
    public String toString() {
        return "CarrotPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", pitLevel=" + pitLevel +
                '}';
    }
}

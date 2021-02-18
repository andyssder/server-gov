package com.politics.chn.model.dto;

import java.util.Objects;

/**
 * @author: andyssder
 * @create: 2021-02-18 12:00
 */
public class CarrotDTO {
    Long id;
    String name;
    String shortName;

    public CarrotDTO() {
    }

    public CarrotDTO(Long id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarrotDTO carrotDTO = (CarrotDTO) o;
        return Objects.equals(id, carrotDTO.id) && Objects.equals(name, carrotDTO.name) && Objects.equals(shortName, carrotDTO.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName);
    }

    @Override
    public String toString() {
        return "CarrotDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}

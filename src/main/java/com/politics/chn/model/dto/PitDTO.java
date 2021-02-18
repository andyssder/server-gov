package com.politics.chn.model.dto;

import java.util.Objects;

/**
 * @author: andyssder
 * @create: 2021-02-16 17:30
 */
public class PitDTO {
    Long id;
    Long pid;
    String name;
    String shortName;
    Integer rank;
    Integer districtLevel;

    public PitDTO() {

    }

    public PitDTO(Long id, Long pid, String name, String shortName, Integer rank, Integer districtLevel) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.shortName = shortName;
        this.rank = rank;
        this.districtLevel = districtLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getDistrictLevel() {
        return districtLevel;
    }

    public void setDistrictLevel(Integer districtLevel) {
        this.districtLevel = districtLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PitDTO pitDTO = (PitDTO) o;
        return Objects.equals(id, pitDTO.id) && Objects.equals(pid, pitDTO.pid) && Objects.equals(name, pitDTO.name) && Objects.equals(shortName, pitDTO.shortName) && Objects.equals(rank, pitDTO.rank) && Objects.equals(districtLevel, pitDTO.districtLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, name, shortName, rank, districtLevel);
    }

    @Override
    public String toString() {
        return "PitDTO{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", rank=" + rank +
                ", districtLevel=" + districtLevel +
                '}';
    }
}

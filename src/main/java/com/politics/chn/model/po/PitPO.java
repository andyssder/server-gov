package com.politics.chn.model.po;

import java.util.Objects;

/**
 * @author: andyssder
 * @create: 2021-02-08 17:15
 */
public class PitPO {
    Long id;
    Long pid;
    String name;
    String shortName;
    Integer level;
    Integer rank;
    Integer districtLevel;
    Integer lft;
    Integer rgt;
    Boolean isDeleted;

    public PitPO() {
    }

    public PitPO(Long pid, String name, int level, int rank, int districtLevel, int lft, int rgt) {
        this(pid, name, null, level, rank, districtLevel, lft, rgt, false);
    }

    public PitPO(Long pid, String name, String shortName, int level, int rank, int districtLevel, int lft, int rgt) {
        this(pid, name, shortName, level, rank, districtLevel, lft, rgt, false);
    }

    public PitPO(Long pid, String name, String shortName, int level, int rank, int districtLevel, int lft, int rgt, boolean isDeleted) {
        this.pid = pid;
        this.name = name;
        this.shortName = shortName;
        this.level = level;
        this.rank = rank;
        this.districtLevel = districtLevel;
        this.lft = lft;
        this.rgt = rgt;
        this.isDeleted = isDeleted;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public Integer getLft() {
        return lft;
    }

    public void setLft(Integer lft) {
        this.lft = lft;
    }

    public Integer getRgt() {
        return rgt;
    }

    public void setRgt(Integer rgt) {
        this.rgt = rgt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
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
        PitPO pitPO = (PitPO) o;
        return Objects.equals(id, pitPO.id) && Objects.equals(pid, pitPO.pid) && Objects.equals(name, pitPO.name) && Objects.equals(shortName, pitPO.shortName) && Objects.equals(level, pitPO.level) && Objects.equals(rank, pitPO.rank) && Objects.equals(districtLevel, pitPO.districtLevel) && Objects.equals(lft, pitPO.lft) && Objects.equals(rgt, pitPO.rgt) && Objects.equals(isDeleted, pitPO.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, name, shortName, level, rank, districtLevel, lft, rgt, isDeleted);
    }

    @Override
    public String toString() {
        return "PitPO{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", level=" + level +
                ", rank=" + rank +
                ", districtLevel=" + districtLevel +
                ", lft=" + lft +
                ", rgt=" + rgt +
                ", isDeleted=" + isDeleted +
                '}';
    }
}

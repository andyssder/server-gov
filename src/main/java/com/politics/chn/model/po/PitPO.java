package com.politics.chn.model.po;

import java.util.Objects;

/**
 * @author: andyssder
 * @create: 2021-02-08 17:15
 */
public class PitPO {
    long id;
    String name;
    String shortName;
    int level;
    int rank;
    int districtLevel;
    int lft;
    int rgt;
    boolean isDeleted;

    public PitPO() {
    }

    public PitPO(String name, int level, int rank, int districtLevel, int lft, int rgt) {
        this(name, null, level, rank, districtLevel, lft, rgt, false);
    }

    public PitPO(String name, String shortName, int level, int rank, int districtLevel, int lft, int rgt) {
        this(name, shortName, level, rank, districtLevel, lft, rgt, false);
    }

    public PitPO(String name, String shortName, int level, int rank, int districtLevel, int lft, int rgt, boolean isDeleted) {
        this.name = name;
        this.shortName = shortName;
        this.level = level;
        this.rank = rank;
        this.districtLevel = districtLevel;
        this.lft = lft;
        this.rgt = rgt;
        this.isDeleted = isDeleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getDistrictLevel() {
        return districtLevel;
    }

    public void setDistrictLevel(int districtLevel) {
        this.districtLevel = districtLevel;
    }

    public int getLft() {
        return lft;
    }

    public void setLft(int lft) {
        this.lft = lft;
    }

    public int getRgt() {
        return rgt;
    }

    public void setRgt(int rgt) {
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
        return id == pitPO.id && level == pitPO.level && rank == pitPO.rank && districtLevel == pitPO.districtLevel && lft == pitPO.lft && rgt == pitPO.rgt && isDeleted == pitPO.isDeleted && Objects.equals(name, pitPO.name) && Objects.equals(shortName, pitPO.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName, level, rank, districtLevel, lft, rgt, isDeleted);
    }

    @Override
    public String toString() {
        return "PitPO{" +
                "id=" + id +
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

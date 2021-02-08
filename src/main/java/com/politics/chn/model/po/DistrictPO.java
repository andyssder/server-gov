package com.politics.chn.model.po;

import java.util.Objects;

/**
 * @author: andyssder
 * @create: 2021-02-06 16:43
 */
public class DistrictPO {
    int id;
    String name;
    int code;
    int level;
    int lft;
    int rgt;

    public DistrictPO() {

    }

    public DistrictPO(int id, String name, int code, int level, int lft, int rgt) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.level = level;
        this.lft = lft;
        this.rgt = rgt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    @Override
    public String toString() {
        return "DistrictPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", level=" + level +
                ", lft=" + lft +
                ", rgt=" + rgt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DistrictPO that = (DistrictPO) o;
        return id == that.id && code == that.code && level == that.level && lft == that.lft && rgt == that.rgt && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, level, lft, rgt);
    }
}
package com.politics.chn.repo.official.po;

import java.util.Objects;

/**
 * @since 2021-02-19
 * @author andyssder
 */
public class DistrictPO {
    Integer id;
    String name;
    Integer code;
    Integer level;
    Integer lft;
    Integer rgt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DistrictPO that = (DistrictPO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(level, that.level) && Objects.equals(lft, that.lft) && Objects.equals(rgt, that.rgt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, level, lft, rgt);
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
}

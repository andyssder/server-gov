package com.politics.chn.model.domain.value;

import java.util.List;
import java.util.Objects;

/**
 * @author andyssder
 * @create 2021-02-19 20:17
 */
public class DistrictDO {
    Integer id;
    String name;
    Integer code;
    Integer level;
    Integer lft;
    Integer rgt;
    List<String> names;

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

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DistrictDO that = (DistrictDO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(level, that.level) && Objects.equals(lft, that.lft) && Objects.equals(rgt, that.rgt) && Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, level, lft, rgt, names);
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
                ", names=" + names +
                '}';
    }

    public String getFullName() {
        StringBuffer sb = new StringBuffer();
        names.forEach(name -> sb.append(name));
        sb.append(name);
        return sb.toString();
    }
}

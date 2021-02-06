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
    int lbb;
    int ubb;

    public DistrictPO() {

    }

    public DistrictPO(int id, String name, int code, int level, int lbb, int ubb) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.level = level;
        this.lbb = lbb;
        this.ubb = ubb;
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

    public int getLbb() {
        return lbb;
    }

    public void setLbb(int lbb) {
        this.lbb = lbb;
    }

    public int getUbb() {
        return ubb;
    }

    public void setUbb(int ubb) {
        this.ubb = ubb;
    }

    @Override
    public String toString() {
        return "LocationPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", level=" + level +
                ", lbb=" + lbb +
                ", ubb=" + ubb +
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
        return id == that.id && code == that.code && level == that.level && lbb == that.lbb && ubb == that.ubb && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, level, lbb, ubb);
    }
}
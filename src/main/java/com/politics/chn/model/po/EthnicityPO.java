package com.politics.chn.model.po;

import java.util.Objects;

/**
 * @author: andyssder
 * @create: 2021-02-18 17:26
 */
public class EthnicityPO {
    Integer id;
    String name;

    public EthnicityPO() {
    }

    public EthnicityPO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EthnicityPO that = (EthnicityPO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "EthnicityPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.politics.chn.model.domain.value;

import java.util.Objects;

/**
 * @author andyssder
 * @create 2021-02-19 19:58
 */
public class EthnicityDO {
    Integer id;
    String name;

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
        EthnicityDO that = (EthnicityDO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "EthnicityDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

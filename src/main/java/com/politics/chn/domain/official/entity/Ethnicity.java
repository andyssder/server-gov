package com.politics.chn.domain.official.entity;

import com.politics.chn.common.utils.StringUtils;
import com.politics.chn.domain.common.Entity;

import java.util.Objects;

/**
 * @since 2021-02-19
 * @author andyssder
 */
public class Ethnicity implements Entity {
    Integer id;
    String name;

    public Ethnicity(Integer id, String name) {
        assert StringUtils.isNotBlank(name);
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
        Ethnicity that = (Ethnicity) o;
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

package com.politics.chn.domain.official.entity;

import com.politics.chn.common.utils.StringUtils;

import java.util.Objects;

/**
 * @since 2021-02-19
 * @author andyssder
 */
public class Party {
    Integer id;
    String name;
    String shortName;

    public Party(Integer id, String name, String shortName) {
        assert StringUtils.isNotBlank(name);
        assert StringUtils.isNotBlank(shortName);
        this.id = id;
        this.name = name;
        this.shortName = shortName;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Party party = (Party) o;
        return Objects.equals(id, party.id) && Objects.equals(name, party.name) && Objects.equals(shortName, party.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName);
    }

    @Override
    public String toString() {
        return "PartyPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}

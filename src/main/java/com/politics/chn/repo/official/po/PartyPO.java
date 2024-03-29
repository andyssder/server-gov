package com.politics.chn.repo.official.po;

import java.util.Objects;

/**
 * @since 2021-02-19
 * @author andyssder
 */
public class PartyPO {
    Integer id;
    String name;
    String shortName;

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
        PartyPO partyPO = (PartyPO) o;
        return Objects.equals(id, partyPO.id) && Objects.equals(name, partyPO.name) && Objects.equals(shortName, partyPO.shortName);
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

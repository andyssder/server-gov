package com.politics.chn.model.domain.value;

import java.util.Objects;

/**
 * @author andyssder
 * @create 2021-02-19 19:57
 */
public class PartyDO {
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
        PartyDO partyDO = (PartyDO) o;
        return Objects.equals(id, partyDO.id) && Objects.equals(name, partyDO.name) && Objects.equals(shortName, partyDO.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortName);
    }

    @Override
    public String toString() {
        return "PartyDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}

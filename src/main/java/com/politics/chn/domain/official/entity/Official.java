package com.politics.chn.domain.official.entity;

import cn.hutool.core.collection.ListUtil;

import java.util.List;
import java.util.Objects;

/**
 * @since 2021-02-19
 * @author andyssder
 */
public class Official {
    Person person;
    List<Profile> profiles;

    public Official() {
    }

    public Official(Person person) {
        this.person = person;
    }

    public Official(Person person, List<Profile> profiles) {
        this.person = person;
        this.profiles = profiles;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Official that = (Official) o;
        return Objects.equals(person, that.person) && Objects.equals(profiles, that.profiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, profiles);
    }

    @Override
    public String toString() {
        return "Official{" +
                "person=" + person +
                ", profiles=" + profiles +
                '}';
    }

    public Boolean isNotNull() {
        return person.isNotNull() && profiles != null && !ListUtil.filter(profiles, profile -> {
            return profile.isNotNull() ? profile : null;
        }).isEmpty();
    }
}

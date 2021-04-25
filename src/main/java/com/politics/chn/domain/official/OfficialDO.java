package com.politics.chn.domain.official;

import cn.hutool.core.collection.ListUtil;
import com.politics.chn.domain.official.entity.PersonDO;
import com.politics.chn.domain.official.entity.ProfileDO;

import java.util.List;
import java.util.Objects;

/**
 * @since 2021-02-19
 * @author andyssder
 */
public class OfficialDO {
    PersonDO person;
    List<ProfileDO> profiles;

    public OfficialDO() {
    }

    public OfficialDO(PersonDO person) {
        this.person = person;
    }

    public OfficialDO(PersonDO person, List<ProfileDO> profiles) {
        this.person = person;
        this.profiles = profiles;
    }

    public PersonDO getPerson() {
        return person;
    }

    public void setPerson(PersonDO person) {
        this.person = person;
    }

    public List<ProfileDO> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileDO> profiles) {
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
        OfficialDO that = (OfficialDO) o;
        return Objects.equals(person, that.person) && Objects.equals(profiles, that.profiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, profiles);
    }

    @Override
    public String toString() {
        return "OfficialDO{" +
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

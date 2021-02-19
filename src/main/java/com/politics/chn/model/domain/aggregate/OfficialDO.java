package com.politics.chn.model.domain.aggregate;

import com.politics.chn.model.domain.entity.PersonDO;
import com.politics.chn.model.domain.entity.ProfileDO;

import java.util.List;
import java.util.Objects;

/**
 * @author andyssder
 * @create 2021-02-19 19:52
 */
public class OfficialDO {
    PersonDO person;
    List<ProfileDO> profiles;

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
        return "OfficialAR{" +
                "person=" + person +
                ", profiles=" + profiles +
                '}';
    }
}

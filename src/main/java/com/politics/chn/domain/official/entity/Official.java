package com.politics.chn.domain.official.entity;

import com.politics.chn.domain.common.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @since 2021-02-19
 * @author andyssder
 */
@Data
@AllArgsConstructor
public class Official implements Entity {
    Person person;
    List<Profile> profiles;

    public Official(Person person) {
        this.person = person;
    }
}

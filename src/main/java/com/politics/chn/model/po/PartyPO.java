package com.politics.chn.model.po;

/**
 * @author: andyssder
 * @create: 2021-02-18 14:34
 */
public class PartyPO {
    Integer id;
    String name;
    String shortName;

    public PartyPO() {
    }

    public PartyPO(Integer id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }
}

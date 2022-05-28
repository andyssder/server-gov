package com.politics.chn.domain.official.entity;

import com.politics.chn.domain.common.Entity;

import java.util.List;
import java.util.Objects;

/**
 * @since 2021-02-19
 * @author andyssder
 */
public class Pit implements Entity {

    // TODO 验证参数
    Long id;
    Long pid;
    String name;
    String shortName;
    Integer level;
    Integer ranking;
    Integer districtLevel;
    Integer lft;
    Integer rgt;

    Boolean enabled;
    Boolean deleted;

    List<String> names;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getDistrictLevel() {
        return districtLevel;
    }

    public void setDistrictLevel(Integer districtLevel) {
        this.districtLevel = districtLevel;
    }

    public Integer getLft() {
        return lft;
    }

    public void setLft(Integer lft) {
        this.lft = lft;
    }

    public Integer getRgt() {
        return rgt;
    }

    public void setRgt(Integer rgt) {
        this.rgt = rgt;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pit pit = (Pit) o;
        return Objects.equals(id, pit.id) && Objects.equals(pid, pit.pid) && Objects.equals(name, pit.name) && Objects.equals(shortName, pit.shortName) && Objects.equals(level, pit.level) && Objects.equals(ranking, pit.ranking) && Objects.equals(districtLevel, pit.districtLevel) && Objects.equals(lft, pit.lft) && Objects.equals(rgt, pit.rgt) && Objects.equals(enabled, pit.enabled) && Objects.equals(deleted, pit.deleted) && Objects.equals(names, pit.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pid, name, shortName, level, ranking, districtLevel, lft, rgt, enabled, deleted, names);
    }

    @Override
    public String toString() {
        return "Pit{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", level=" + level +
                ", ranking=" + ranking +
                ", districtLevel=" + districtLevel +
                ", lft=" + lft +
                ", rgt=" + rgt +
                ", enabled=" + enabled +
                ", deleted=" + deleted +
                ", names=" + names +
                '}';
    }

    public String fullName() {
        StringBuffer sb = new StringBuffer();
        names.forEach(name -> sb.append(name));
        sb.append(name);
        return sb.toString();
    }

    public Boolean isNotNull() {
        return pid != null && name != null && districtLevel != null && ranking != null;
    }
}

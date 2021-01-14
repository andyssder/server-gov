package com.politics.chn.model;

import java.util.Date;
import java.util.List;

public class Person {
    int id;
    String name;
    String portrait;
    int gender;
    String ethnicity;
    String party;
    Date birthDate;
    Date deathDate;
    Date workDate;
    District ancestralHome;
    District location;
    String education;
    String university;
    String degree;
    String family;
    Carrot carrot;
    int level;
    List<Profile> profiles;

    public Person() {
        this("", 1);
    }

    public Person(String name, int gender) {
        this.name = name;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public District getAncestralHome() {
        return ancestralHome;
    }

    public void setAncestralHome(District ancestralHome) {
        this.ancestralHome = ancestralHome;
    }

    public District getLocation() {
        return location;
    }

    public void setLocation(District location) {
        this.location = location;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Carrot getCarrot() {
        return carrot;
    }

    public void setCarrot(Carrot carrot) {
        this.carrot = carrot;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", portrait='" + portrait + '\'' +
                ", gender=" + gender +
                ", ethnicity='" + ethnicity + '\'' +
                ", party='" + party + '\'' +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                ", workDate=" + workDate +
                ", ancestralHome=" + ancestralHome +
                ", location=" + location +
                ", education='" + education + '\'' +
                ", university='" + university + '\'' +
                ", degree='" + degree + '\'' +
                ", family='" + family + '\'' +
                ", carrot=" + carrot +
                ", level=" + level +
                ", profiles=" + profiles +
                '}';
    }
}

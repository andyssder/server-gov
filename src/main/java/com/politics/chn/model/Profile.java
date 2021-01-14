package com.politics.chn.model;

import java.util.Date;

public class Profile {
    int id;
    Date startTime;
    Date endTime;
    Carrot carrot;
    Person person;

    public Profile() {
        this(new Date(), new Carrot());
    }

    public Profile(Date startTime, Carrot carrot) {
        this(startTime, null, carrot, null);
    }

    public Profile(Date startTime, Date endTime, Carrot carrot, Person person) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.carrot = carrot;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Carrot getCarrot() {
        return carrot;
    }

    public void setCarrot(Carrot carrot) {
        this.carrot = carrot;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", carrot=" + carrot +
                ", person=" + person +
                '}';
    }
}

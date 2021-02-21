package com.prger.bean;

public class Skill extends BaseBean {

    private String name;
    private Integer level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Skill() {
    }

    public Skill(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", id=" + getId() +
                ", createdTime=" + getCreatedTime() +
                '}';
    }
}

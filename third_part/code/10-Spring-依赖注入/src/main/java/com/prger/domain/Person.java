package com.prger.domain;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Person {
    private Integer age;
    private String name;
    private Dog dog;
    private BigDecimal amout;
    private List<String> list;
    private Map<String, String> friends;

    public Person() {
    }

    @ConstructorProperties({"age", "name"})
    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(Dog dog) {
        this.dog = dog;
    }

    public Person(List<String> list) {
        this.list = list;
    }

    public void setFriends(Map<String, String> friends) {
        this.friends = friends;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setAmout(BigDecimal amout) {
        this.amout = amout;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", dog=" + dog +
                ", amout=" + amout +
                ", list=" + list +
                ", friends=" + friends +
                '}';
    }
}

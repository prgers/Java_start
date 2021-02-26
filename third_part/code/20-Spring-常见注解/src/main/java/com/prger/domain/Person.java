package com.prger.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton")
@PropertySource("data.properties")
public class Person {


    private Dog dog;

    @Value("${name}")
    private String name;

    @Value("${age}")
    private String age;


    @Autowired
    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "dog=" + dog +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

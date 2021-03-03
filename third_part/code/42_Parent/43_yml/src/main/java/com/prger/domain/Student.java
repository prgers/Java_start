package com.prger.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@ConfigurationProperties("student")
@Data
public class Student {
    private String name;
    private List<String> hobbies;
    private Set<Integer> numbers;
    private String[] jobs;
    private Map<String, String> homes;
    private Dog dog;
    private List<Book> books;

    @Data
    public static class Dog {
        private Integer age;
        private String name;
    }

    @Data
    public static class Book {
        private Double price;
        private String name;
    }
}

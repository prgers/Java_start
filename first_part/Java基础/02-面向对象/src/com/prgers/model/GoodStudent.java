package com.prgers.model;

public class GoodStudent extends Student{

    public Integer salary;

    @Override
    public String toString() {
        return "GoodStudent{" +
                "salary=" + salary +
                ", no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}

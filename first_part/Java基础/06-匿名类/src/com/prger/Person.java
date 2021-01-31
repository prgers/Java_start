package com.prger;

public class Person implements Runnable{
    @Override
    public void run() {
        System.out.println("Person - run()");
    }
}

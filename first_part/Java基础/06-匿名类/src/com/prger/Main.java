package com.prger;

import com.prger.utils.Times;

public class Main {

    public static void main(String[] args) {

        Person person = new Person();
        person.run();

       Runnable person1 = new Runnable(){

            @Override
            public void run() {
                System.out.println("run()");
            }
        };

       person1.run();

       Times.test(new Times.Block() {
           @Override
           public void execute() {

           }
       });
    }
}

package com.prger.proxy;

import com.prger.service.PersonService;

public class PersonProxy implements PersonService {

    private PersonService service;

    public void setService(PersonService service) {
        this.service = service;
    }

    @Override
    public boolean login(String username, String password) {

        System.out.println("日志-------------------------1");
        boolean result = service.login(username, password);
        System.out.println("日志-------------------------2");
        return result;
    }
}

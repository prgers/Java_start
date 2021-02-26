package com.prger.service.impl;

import com.prger.dao.PersonDao;
import com.prger.service.PersonService;

public class PersonServiceImpl implements PersonService {

//    private PersonDao dao = GeneralFactory.get("dao");

    private PersonDao dao;

    public void setDao(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean remove(Integer id) {
        return dao.remove(id);
    }
}

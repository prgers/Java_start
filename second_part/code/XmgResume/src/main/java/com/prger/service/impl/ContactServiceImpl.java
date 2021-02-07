package com.prger.service.impl;

import com.prger.bean.Contact;
import com.prger.bean.ContactListParam;
import com.prger.bean.ContactListResult;
import com.prger.dao.ContactDao;
import com.prger.dao.impl.ContactDaoImpl;
import com.prger.service.ContactService;


public class ContactServiceImpl extends BaseServiceImpl<Contact> implements ContactService {

    @Override
    public ContactListResult list(ContactListParam param) {
        return ((ContactDao) dao).list(param);
    }

    @Override
    public boolean read(Integer id) {
        return ((ContactDao) dao).read(id);
    }
}

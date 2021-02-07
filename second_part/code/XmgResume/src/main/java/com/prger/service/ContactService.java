package com.prger.service;

import com.prger.bean.Contact;
import com.prger.bean.ContactListParam;
import com.prger.bean.ContactListResult;

public interface ContactService extends BaseService<Contact> {

    ContactListResult list(ContactListParam param);
    boolean read(Integer id);
}

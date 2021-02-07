package com.prger.dao;

import com.prger.bean.Contact;
import com.prger.bean.ContactListParam;
import com.prger.bean.ContactListResult;

public interface ContactDao extends BaseDao<Contact> {
    ContactListResult list(ContactListParam param);
    boolean read(Integer id);
}

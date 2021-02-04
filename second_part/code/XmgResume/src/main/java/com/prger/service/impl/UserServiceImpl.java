package com.prger.service.impl;

import com.prger.bean.User;
import com.prger.dao.UserDao;
import com.prger.service.UserService;


public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Override
    public User get(User user) {
        return ((UserDao) dao).get(user);
    }
}

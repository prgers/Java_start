package com.prger.dao;

import com.prger.bean.User;

public interface UserDao extends BaseDao<User> {

    User get(User user);
}

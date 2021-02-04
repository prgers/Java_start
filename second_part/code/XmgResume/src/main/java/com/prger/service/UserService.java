package com.prger.service;

import com.prger.bean.User;

public interface UserService extends BaseService<User> {

    User get(User user);
}

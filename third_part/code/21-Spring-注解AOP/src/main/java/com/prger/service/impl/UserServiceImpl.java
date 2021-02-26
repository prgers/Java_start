package com.prger.service.impl;

import com.prger.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public void run() {
        System.out.println("UserServiceImpl - run()");
    }
}

package com.itbaima.service.impl;

import com.itbaima.dao.UserDao;
import com.itbaima.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
        System.out.println(userDao);
    }//这个set方法会直接被框架调用。不用手动调用。
}

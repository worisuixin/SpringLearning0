package com.itbaima.factory;

import com.itbaima.dao.UserDao;
import com.itbaima.dao.impl.UserDaoImpl;

public class MyBeanFactory1 {
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }
}


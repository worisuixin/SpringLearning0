package com.itbaima.service.impl;

import com.itbaima.dao.UserDao;
import com.itbaima.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void init(){
        System.out.println("指定的初始化方法，即在被实例化之后执行的操作");
    }
    public void destroy(){
        System.out.println("指定的销毁方法，销毁方法之后执行的操作");
    }
//    这里上面两个方法都是用来对Bean配置里面的init-method、destory-method的具体参数的配置。

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
        System.out.println(userDao);
    }//这个set方法会直接被框架调用。不用手动调用。
}

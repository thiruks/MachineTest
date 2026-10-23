package com.onedao.devtask.service;

import com.onedao.devtask.model.User;

public class UserServiceImpl implements  UserService{


    @Override
    public User findByUsername(String username, String pwd) {

        //To do Parameterised statement to avoid the sql injection
        return null;
    }

    @Override
    public User signUp(User user) {
        //To do Parameterised statement to avoid the sql injection
        return null;
    }
}

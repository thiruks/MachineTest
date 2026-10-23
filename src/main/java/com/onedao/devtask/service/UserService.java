package com.onedao.devtask.service;

import com.onedao.devtask.model.User;

public interface UserService {

    User findByUsername(String username, String pwd);
    User signUp(User user);

}

package com.alex.service;

import com.alex.entity.User;

public interface UserService {
    User getUser(Integer id);

    Integer createUser(String userName, String password);
}

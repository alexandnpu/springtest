package com.alex.service.impl;

import com.alex.entity.User;
import com.alex.mappers.UserMapper;
import com.alex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUser(Integer id) {
        return userMapper.getUser(id);
    }
}

package com.alex.service.impl;

import com.alex.entity.User;
import com.alex.mappers.UserMapper;
import com.alex.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;


@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(@Qualifier(value = "com.alex.mappers.UserMapper") UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUser(Integer id) {
        return userMapper.getUser(id);
    }

    @Transactional
    public Integer createUser(String userName, String password) {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        User user = new User();
        user.setName(userName);
        user.setSecretHash(password);
        user.setUserHash(password);
        user.setIsDeleted(0);
        user.setCreatedAt(currentTimestamp);
        user.setUpdatedAt(currentTimestamp);

        Integer numberOfUserCreated = this.userMapper.insertUser(user);
        logger.info("newly created user id is " + user.getId());
        return numberOfUserCreated;
    }
}

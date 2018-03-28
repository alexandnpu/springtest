package com.alex.mappers;

import com.alex.entity.User;

public interface UserMapper {
    User getUser(Integer id);

    Integer insertUser(User user);
}

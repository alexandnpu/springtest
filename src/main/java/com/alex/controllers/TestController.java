package com.alex.controllers;

import com.alex.entity.User;
import com.alex.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


@RestController
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    private static final String template = "Hello, version 1.3, %s!";
    private final AtomicLong counter = new AtomicLong();

    private UserService userService;

    @Autowired
    public TestController(@Qualifier(value = "com.alex.service.impl.UserServiceImpl") UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public User getUser(@RequestParam(value = "id") Integer id) {
        return userService.getUser(id);
    }

    @RequestMapping(path = "/user", method = RequestMethod.PUT)
    public Integer createUser(@RequestBody CreateUserParameters createUserParameters) {
        Integer numberOfUserCreated = userService.createUser(createUserParameters.getName(), createUserParameters.getPassword());
        logger.info(numberOfUserCreated + " user(s) created");
        return numberOfUserCreated;
    }
}

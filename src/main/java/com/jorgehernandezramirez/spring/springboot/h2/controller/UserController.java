package com.jorgehernandezramirez.spring.springboot.h2.controller;

import com.jorgehernandezramirez.spring.springboot.h2.service.api.IUserService;
import com.jorgehernandezramirez.spring.springboot.h2.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertUser(@RequestBody UserDto userDto) {
        userService.insertUser(userDto);
    }
}

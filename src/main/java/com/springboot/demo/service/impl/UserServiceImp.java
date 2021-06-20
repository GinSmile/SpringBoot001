package com.springboot.demo.service.impl;

import com.springboot.demo.mapper.UserMapper;
import com.springboot.demo.model.User;
import com.springboot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUser(int id) {
        return userMapper.selectUser(id);
    }
}

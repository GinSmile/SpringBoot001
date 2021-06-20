package com.springboot.demo.mapper;

import com.springboot.demo.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    User selectUser(int id);
}

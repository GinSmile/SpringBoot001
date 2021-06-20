package com.springboot.demo.Controller;

import com.springboot.demo.model.User;
import com.springboot.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Api(tags = "User对象的操作接口")
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;


    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @GetMapping("/")
    @ApiOperation("获取所有用户列表")
    public List<User> getUserList() {
        return new ArrayList<>(users.values());
    }

    @PostMapping("/")
    @ApiOperation("添加用户")
    public String postUser(@RequestBody User user) {
        users.put(user.getId(), user);
        return "success";
    }

    /*@GetMapping("/{id}")
    @ApiOperation("获取某个用户信息")
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }*/

    @GetMapping("/{id}")
    @ApiOperation("获取某个用户信息-mybatis")
    public User getUserByMybatis(@PathVariable int id) {
        return userService.selectUser(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("修改用户信息")
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        if (users == null || users.isEmpty()) {
            return "fail. no data.";
        }
        User u = users.get(id);
        u.setId(id);
        u.setAge(user.getAge());
        u.setName(user.getName());

        return "success";
    }

    @ApiOperation("删除某个用户")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);

        return "success";
    }
}

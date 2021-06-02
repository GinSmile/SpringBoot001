package com.springboot.demo.Controller;

import com.springboot.demo.Utils.CommonUtils;
import com.springboot.demo.model.School;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "主控制器")
@RequestMapping("/api/index")
public class IndexController {
    // value注解实现单个配置的读取
    @Value("${school.name}")
    private String schoolname;
    @Value("${school.website}")
    private String website;

    @GetMapping(value = "/hello")
    @ApiOperation("获取application配置")
    public @ResponseBody Object hello() {
        return "Hello! Spring boot!\n" +  schoolname + "\n" + website + "\n" + CommonUtils.getFormattedTime();
    }

    // 自动装配
    @Autowired
    private School school;

    @GetMapping(value = "/school")
    @ApiOperation("获取model")
    public @ResponseBody Object school() {
        return "school.name=" + school.getName() + ", school.website=" + school.getWebsite();
    }
}
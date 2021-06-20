package com.springboot.demo.Controller;

import com.springboot.demo.Utils.CommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public Object getApplicationProperties() {
        return "Hello! Spring boot!\n" +  schoolname + "\n" + website + "\n" + CommonUtils.getFormattedTime();
    }
}
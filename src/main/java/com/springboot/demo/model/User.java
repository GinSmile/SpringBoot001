package com.springboot.demo.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class User {
    private Long id;
    private String name;
    private Integer age;
}

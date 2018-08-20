package com.lch.spring.boot.lesson4;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @ClassName SpringBootLesson4Application
 * @Description Spring Boot学习第四节
 * @Authod lichanghong
 * @Date 2018/8/20 12:27
 **/
@SpringBootApplication
public class SpringBootLesson4Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootLesson4Application.class).web(WebApplicationType.SERVLET).run(args);
    }
}

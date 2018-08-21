package com.lch.spring.boot.lesson4;

import com.lch.spring.boot.lesson4.spring.boot.MyServlet2;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName SpringBootLesson4Application
 * @Description Spring Boot学习第四节
 * @Authod lichanghong
 * @Date 2018/8/20 12:27
 **/
@SpringBootApplication
//设置servlet扫描类路径
@ServletComponentScan(basePackages =
        {"com.lch.spring.boot.lesson4.servlet"})
public class SpringBootLesson4Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootLesson4Application.class).
                web(WebApplicationType.SERVLET).run(args);
    }
    @Bean
    public static ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        //注册servlet
        servletRegistrationBean.setServlet(new MyServlet2());
        //设置映射信息
        servletRegistrationBean.addUrlMappings("/spring-boot/myServlet2");
        //设置启动参数
        servletRegistrationBean.addInitParameter("myName", "myValue");
        return servletRegistrationBean;
    }
}

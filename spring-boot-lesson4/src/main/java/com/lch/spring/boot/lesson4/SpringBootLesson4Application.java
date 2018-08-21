package com.lch.spring.boot.lesson4;

import com.lch.spring.boot.lesson4.spring.boot.MyFilter2;
import com.lch.spring.boot.lesson4.spring.boot.MyServlet2;
import com.lch.spring.boot.lesson4.spring.boot.MyServletListener2;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;

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
public class SpringBootLesson4Application extends SpringBootServletInitializer {
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
      /**
          * 声明一个filter的bean
          **/
    @Bean
    public static FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
       //设置filter
        filterRegistrationBean.setFilter(new MyFilter2());
        //设置拦截路径
        filterRegistrationBean.addUrlPatterns("/spring-boot/*");
        //设置调度类型
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE);
        return filterRegistrationBean;
    }
     /**
         * 声明一个事件监听器的bean
         * @param
         * @return
         * @date        2018/8/21 11:21
         **/
     @Bean
    public static ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
            //设置事件监听
            servletListenerRegistrationBean.setListener(new MyServletListener2());
        return servletListenerRegistrationBean;
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(SpringBootLesson4Application.class);
         return builder;
    }
}

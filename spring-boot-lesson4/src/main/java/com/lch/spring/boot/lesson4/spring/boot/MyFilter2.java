package com.lch.spring.boot.lesson4.spring.boot;


import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyFilter2
 * @Description 演示filter
 * @Authod lichanghong
 * @Date 2018/8/20 16:50
 **/
public class MyFilter2 extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        //ServletContext servletContext = getServletContext()f;
        //servletContext 和 context是等价的
        String url = request.getRequestURI();
        context.log(url+"     filterInternal....");
        doSomething();
        filterChain.doFilter(request, response);
    }
     /**
         * 如果方法中没有传递HttpServletRequest对象，可以使用下面的方法来获取
         *
         **/
    public void doSomething(){
        //通过 RequestContextHolder 线程上下文来获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //将RequestContextHolder强转为ServletRequestAttributes
        /*
        ServletRequestAttributes继承了AbstractRequestAttributes，
        AbstractRequestAttributes 实现了RequestAttributes接口
         */
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        /*
        *获取HttpServletRequest对象
         */
        HttpServletRequest request = servletRequestAttributes.getRequest();
        /*
            获取servletContext
         */
        ServletContext context = request.getServletContext();
        String requestUrl = request.getRequestURI();
        context.log("通过RequestContextHolder来过去上下文及HttpServletRequest");
    }
}

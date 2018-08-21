package com.lch.spring.boot.lesson4.servlet;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Description 演示filter
 * @Authod lichanghong
 * @Date 2018/8/20 16:50
 **/
@WebFilter(servletNames = "myServlet",urlPatterns = "/myServlet")
public class MyFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        //ServletContext servletContext = getServletContext()f;
        //servletContext 和 context是等价的
        context.log("myServlet     filterInternal....");
        filterChain.doFilter(request, response);
    }
}

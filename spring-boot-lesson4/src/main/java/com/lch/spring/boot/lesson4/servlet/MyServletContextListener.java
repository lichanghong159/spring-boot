package com.lch.spring.boot.lesson4.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName MyServletListener1
 * @Description
 * @Authod lichanghong
 * @Date 2018/8/20 17:30
 **/
@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context =sce.getServletContext();
        context.log("ServletContextListener     initialized............");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context =sce.getServletContext();
        context.log("ServletContextListener     destroyed............");
    }
}

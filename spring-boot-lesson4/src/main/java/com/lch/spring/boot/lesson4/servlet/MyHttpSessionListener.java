package com.lch.spring.boot.lesson4.servlet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @ClassName MyHttpSessionListener
 * @Description
 * @Authod lichanghong
 * @Date 2018/8/20 17:34
 **/
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context =se.getSession().getServletContext();
        context.log("sessionCreated ............");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context =se.getSession().getServletContext();
        context.log("sessionDestroyed ............");
    }
}

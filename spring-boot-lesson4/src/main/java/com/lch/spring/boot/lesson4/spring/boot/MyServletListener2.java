package com.lch.spring.boot.lesson4.spring.boot;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName MyServletListener2
 * @Description 事件监听
 * @Authod lichanghong
 * @Date 2018/8/20 17:06
 **/
public class MyServletListener2 implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletContext context =sre.getServletContext();
        context.log("MyServletListener2 request    destroyed............");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletContext context =sre.getServletContext();
        context.log("MyServletListener2 request    initialized............");
    }
}

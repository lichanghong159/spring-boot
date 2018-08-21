package com.lch.spring.boot.lesson4.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName MyServlet
 * @Description
 * @Authod lichanghong
 * @Date 2018/8/20 15:08
 **/
@WebServlet(
        name = "myServlet",
        urlPatterns = {"/myServlet"},
        initParams = {//增加启动参数
                @WebInitParam(name = "myValue",value = "myValue")
        }
        )
public class MyServlet extends HttpServlet {
    private String value;
    //获取初始化参数
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        value = config.getInitParameter("myValue");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter writer =resp.getWriter();
        ServletContext context = getServletContext();
        context.log("doGet().....");
        writer.write("<html><body>Hello,World--InitParameter:"+value+"</body></html>");
    }
}

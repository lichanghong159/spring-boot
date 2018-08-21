package com.lch.spring.boot.lesson4.spring.boot;



import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @ClassName MyServlet2
 * @Description Spring-boot-API注册servlet
 * @Authod lichanghong
 * @Date 2018/8/20 17:53
 **/
public class MyServlet2 extends HttpServlet {
    private String value;
    //获取初始化参数
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        value = config.getInitParameter("myName");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter writer =resp.getWriter();
        ServletContext context = getServletContext();
        String url = req.getRequestURI();
        context.log(url+" doGet().....");
        writer.write("<html><body>Hello,World。MyServlet2--InitParameter:"+value+"</body></html>");
    }
}

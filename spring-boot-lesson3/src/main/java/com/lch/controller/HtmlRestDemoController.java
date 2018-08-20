package com.lch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: lichanghong on 2018-08-19
 **/
//@Controller
@RestController
public class HtmlRestDemoController {
    /**
     * 在@Controller方法不加@ResponseBody会自动加载模版渲染引擎。
     * @RestController 相当于加了@Controller 和@ResponseBody
     */
    //响应html
    @RequestMapping(value = {"/html/demo","/html/demo2"})
    @ResponseBody
    public String htmlCode(){
        return "<html><body>Hello,World</body></html>";
    }

    /**
     *演示@PathVariable
     * http://localhost/html/demo/World
     */
    @GetMapping(value = "/html/demo/{msg}")
    public String htmlPathVariable(@PathVariable String msg){
        return "<html><body>Hello,"+msg+"</body></html>";
    }
    @GetMapping(path ="/html/demo/param" )
    public String htmlParam(@RequestParam(value = "p",required = false,defaultValue = "Empty")String param,
                            @RequestParam(value = "age",required = false,defaultValue = "0") Integer age){
        return "<html><body>Hello,"+
                "param Value:"+param+
                "age Value:"+age+
                "</body></html>";
    }

    /**
     * 获取请求头中的指定信息
     * @param acceptHeader
     * @return
     */
    @GetMapping(value = "/html/demo/header")
    public String htmlHeader(@RequestHeader(value = "Accept")String acceptHeader){
        return "<html><body>acceptHeader,"+acceptHeader+"</body></html>";
    }
}

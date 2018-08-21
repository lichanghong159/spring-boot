package com.lch.spring.boot.lesson4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Authod lichanghong
 * @Date 2018/8/21 11:46
 **/
@Controller
public class IndexController {
    @GetMapping(path = "/index")
    public String index(Model model){
        model.addAttribute("message", "World");
        return "index";
    }
}

package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/hello")
    String hello(String username, Model model)
    {
        model.addAttribute("username", username);
        return "hello";
    }

    @RequestMapping("/")
    String Index()
    {
        return "redirect:/books";
    }

    @RequestMapping("/welcome")
    String Welcome()
    {
        return "welcome";
    }

    @RequestMapping("/about")
    String About()
    {
        return "about";
    }
    //ysq映射气
    @RequestMapping("/support")
    String Support(){
        return "support";
    }

    @RequestMapping("/layout")
    String layout(){
        return "layout";
    }
}

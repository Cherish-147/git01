package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/test/hello")
    String hello(Model model)
    {
        model.addAttribute("a", 3);
        model.addAttribute("b", 4);
        model.addAttribute("c", 5);
        return "test/hello";
    }
}

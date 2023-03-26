package com.example.demo;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class HomeController {
    @RequestMapping("/hello")
    String hello(String username, Model model)
    {
        model.addAttribute("username", username);
        return "hello";
    }

    @RequestMapping(value="/upload", method= RequestMethod.POST)
    public String onUpload(MultipartFile file) throws IOException {
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.getOriginalFilename());

        FileOutputStream f2 = new FileOutputStream("d:/pic/a.jpg");
        IOUtils.copy(file.getInputStream(), f2);
        f2.close();

        return "hello";
    }


}

package com.example.demo;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
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

        FileOutputStream f2 = new FileOutputStream("G:\\111\\spring综合\\doc_submmit\\src\\main\\resources\\static\\宋昕冉 秋天 树叶 唯美 4k 美女 壁纸_彼岸图网.jpg");//输出
        IOUtils.copy(file.getInputStream(), f2);
        f2.close();

        return "hello";
    }

    @RequestMapping(value="/abc")
    public void getUploadedPicture(HttpServletResponse response) throws IOException {
        //通过response写入图像文件内容
        response.addHeader("content-type", "image/jpg");

//        FileInputStream f = new FileInputStream("D:\\Google\\宋昕冉 秋天 树叶 唯美 4k 美女 壁纸_彼岸图网.jpg");//输入
        FileInputStream f = new FileInputStream("G:\\111\\spring综合\\doc_submmit\\src\\main\\resources\\static\\宋昕冉 秋天 树叶 唯美 4k 美女 壁纸_彼岸图网.jpg");//输入
        IOUtils.copy(f, response.getOutputStream());
    }

//只能同一个文件夹的图片的，否则报错
    //同一文件夹同一zp也不行，有毒，不知道哪里有问题，希望以后能解决
}

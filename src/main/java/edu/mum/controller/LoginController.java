package edu.mum.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class LoginController {


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = {"o"}, method = RequestMethod.GET)
    public String home(Model m) {
        byte[] data = null;
        String str = null;
        try{
            Path path = Paths.get("C:\\Users\\Alvaro\\Desktop\\images.jpg");
            data = Files.readAllBytes(path);
            data = Base64.encodeBase64(data);
            str = new String(data, "UTF-8");

        }catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        m.addAttribute("data",str);
        return "home";
    }


    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String loginPost() {
        return "home";
    }



}
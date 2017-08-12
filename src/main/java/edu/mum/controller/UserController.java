package edu.mum.controller;
import edu.mum.entity.User;
import edu.mum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @PostMapping(value= "/user/add")
    public String add(User user)
    {
        service.save(user);
        return "redirect:/user/all";
    }

    @PostMapping(value= "/user/remove")
    public String remove(User user)
    {
        service.remove(user);
        return "redirect:/user/all";
    }

    @GetMapping(value= "/user/all")
    public String getAll(Model model)
    {
        model.addAttribute(service.getAll());
        return "userAll";
    }

    @GetMapping(value= "/user/detail")
    public String getById(Model model, @RequestParam("id") int id)
    {
        model.addAttribute(service.findById(id));
        return "userDetail";
    }

    @GetMapping(value= "/test")
    public String testMethod()
    {
      //  User u = new User();
      //  u.setFirstName("Sushan");
        //service.saveUser(u);
        return "users";
    }

}

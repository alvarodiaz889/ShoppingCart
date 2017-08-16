package edu.mum.controller;
import edu.mum.entity.Address;
import edu.mum.entity.Role;
import edu.mum.entity.User;
import edu.mum.service.UserService;
import edu.mum.utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    UserService service;

    @PostMapping(value= "/user/add")
    public String add(User user,@RequestParam("city") String city,
                      @RequestParam("country") String country,@RequestParam("state") String state,
                      @RequestParam("zipcode") String zipcode,@RequestParam("addressId") String addressId)
    {
        int id = 0;
        if(!addressId.isEmpty())
            id = Integer.valueOf(addressId);
        Address a = new Address(id,city,zipcode,country,state);
        user.setAddress(a);
        user.addRole("ROLE_REGISTERED");
        service.save(user);
        return "redirect:/";
    }

    @PostMapping(value= "/user/remove")
    public String remove(@RequestParam("id") int id)
    {
        service.removeById(id);
        return "redirect:/user/all";
    }

    @GetMapping(value= "/user/all")
    public String getAll(Model model)
    {
        model.addAttribute("users",service.getAll());
        return "userAll";
    }

    @GetMapping(value= "/register")
    public String getById(Model model)
    {
        model.addAttribute("user",new User());
        model.addAttribute("create",true);
        model.addAttribute("title","Sign up");
        return "userDetail";
    }

    @GetMapping(value= "/user/new")
    public String addNew()
    {
        return "userNew";
    }

    @GetMapping(value= "/user/profile")
    public String getProfileById(Model model, HttpServletRequest request)
    {
        model.addAttribute("user", Utility.getUserFromSession(request,service));
        model.addAttribute("create",false);
        model.addAttribute("title","Profile");
        return "userDetail";
    }
}

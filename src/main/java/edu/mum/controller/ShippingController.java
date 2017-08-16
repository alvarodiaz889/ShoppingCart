package edu.mum.controller;

import edu.mum.entity.Order;
import edu.mum.entity.Shipping;
import edu.mum.service.OrderService;
import edu.mum.service.ShippingService;
import edu.mum.service.UserService;
import edu.mum.utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Sushan on 8/15/2017.
 */
@Controller
public class ShippingController {

    @Autowired
    ShippingService shippingService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;

    @GetMapping("/shop/order")
    public String getInfo(HttpSession session,Model model,HttpServletRequest request){
        model.addAttribute("user", Utility.getUserFromSession(request,userService));
        return "order";
    }

    @PostMapping("/shop/order")
    public String postInfo(@ModelAttribute("shipping") @Valid Shipping shipping, BindingResult result,
            HttpServletRequest request)
    {
        HttpSession session =  request.getSession();
        Order order = (Order)session.getAttribute("order");
        if(result.hasErrors()){
            System.out.println("<-------Error->");
            return "redirect:/shop/order";
        }
        shipping = shippingService.save(shipping);
        order.setShipping(shipping);
        orderService.saveOrder(order);
        session.setAttribute("orderLines",null);
        return "redirect:/shop/checkout";
    }

    @GetMapping("/shop/checkout")
    public String afterPost(){
        return "checkout";
    }
}

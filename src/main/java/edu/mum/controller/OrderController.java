package edu.mum.controller;

import edu.mum.entity.Order;
import edu.mum.entity.OrderLine;
import edu.mum.service.OrderService;
import edu.mum.service.UserService;
import edu.mum.utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @GetMapping("/order/create")
    public String getOrder(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();

        List<OrderLine> orderLines = (List<OrderLine>)session.getAttribute("orderLines");
        if(orderLines == null)
        {
            orderLines = new ArrayList<>();
            session.setAttribute("orderLines",orderLines);
        }

        model.addAttribute("orderLines",orderLines);
        model.addAttribute("user", Utility.getUserFromSession(request,userService));
        return "orderDetail";
    }


}

package edu.mum.controller;

import edu.mum.entity.Order;
import edu.mum.entity.OrderLine;
import edu.mum.service.OrderService;
import edu.mum.service.UserService;
import edu.mum.utilities.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @GetMapping("/order/create")
    public String createOrder(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();

        List<OrderLine> orderLines = (List<OrderLine>)session.getAttribute("orderLines");
        if(orderLines == null)
        {
            orderLines = new ArrayList<>();
            session.setAttribute("orderLines",orderLines);
        }
        int sum =0;
        for(OrderLine objOL:orderLines)
            sum += objOL.getProduct().getPrice() * objOL.getQuantity();
        model.addAttribute("totalAmount",sum);
        model.addAttribute("orderLines",orderLines);
        model.addAttribute("user", Utility.getUserFromSession(request,userService));
        return "orderDetail";
    }

    @PostMapping("/order/save")
    public String saveOrder(Model model, HttpServletRequest request,@RequestParam("amount") int amount){
        HttpSession session = request.getSession();

        List<OrderLine> orderLines = (List<OrderLine>)session.getAttribute("orderLines");
        Order order = new Order();
        order.setOrderLines(orderLines);
        order.setUser(Utility.getUserFromSession(request,userService));
        order.setOrderDate(Date.valueOf(LocalDate.now()));
        order.setTotalPrice(amount);
        session.setAttribute("order",order);
        //orderService.saveOrder(order);
        //session.setAttribute("orderLines",null);
        return "redirect:/shop/order";
    }

    @GetMapping("/order/removeItems")
    public String removeItems(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("orderLines",null);
        model.addAttribute("orderLines", new ArrayList<OrderLine>());
        model.addAttribute("user", Utility.getUserFromSession(request,userService));
        return "orderDetail";
    }
}

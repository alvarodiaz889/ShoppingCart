package edu.mum.controller;

import edu.mum.entity.OrderLine;
import edu.mum.service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderLineController {

    @Autowired
    OrderLineService orderLineService;

    @GetMapping("/orderline")
    public List<OrderLine> getOrderLine(){
        return orderLineService.getAllOrderLine();
    }

    @PostMapping("/orderline")
    public String saveOrderLine(@RequestBody OrderLine orderLine){
        orderLineService.saveOrderLine(orderLine);
        return "Success!";
    }

    @DeleteMapping(value= "/orderline/{orderLineId}")
    public String deleteOrderLine(@PathVariable int orderLineId){
        orderLineService.deleteOrderLine(orderLineId);
        return  "Success delete!";
    }

    @PutMapping(value="/orderline/{OrderLineId}")
    public String updateOrderLine(@RequestBody OrderLine orderLine, @PathVariable int orderLineId){
        orderLine.setOrderLineId(orderLineId);
        orderLineService.updateOrderLine(orderLineId, orderLine);
        return "Success update";
    }

    @GetMapping("/orderline/{OrderLineId}")
    public OrderLine getOneOrderLine(@PathVariable int orderLineId){
        return orderLineService.getOrderLine(orderLineId);
    }
}

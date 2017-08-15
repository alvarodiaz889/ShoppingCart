package edu.mum.service;
import edu.mum.entity.Order;
import edu.mum.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    //create
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    //delete
    public void deleteOrder(int orderId) {
        orderRepository.delete(orderId);
    }

    //read
    public List<Order> getAllOrder() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    public Order getOrder(int orderId) {
        return orderRepository.findOne(orderId);
    }

    //update
    public void updateOrder(int orderId, Order Order) {
        orderRepository.save(Order);
    }
    
}

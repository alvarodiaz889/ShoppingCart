package edu.mum.service;

import edu.mum.entity.OrderLine;
import edu.mum.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderLineService {

    @Autowired
    OrderLineRepository orderLineRepository;

    //create
    public void saveOrderLine(OrderLine orderLine) {
        orderLineRepository.save(orderLine);
    }

    //delete
    public void deleteOrderLine(int orderLineId) {
        orderLineRepository.delete(orderLineId);
    }

    //read
    public List<OrderLine> getAllOrderLine() {
        List<OrderLine> orderLines = orderLineRepository.findAll();
        return orderLines;
    }

    public OrderLine getOrderLine(int orderLineId) {
        return orderLineRepository.findOne(orderLineId);
    }

    //update
    public void updateOrderLine(int orderLineId, OrderLine orderLine) {
        orderLineRepository.save(orderLine);
    }
}

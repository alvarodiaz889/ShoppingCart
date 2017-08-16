package edu.mum.service;

import edu.mum.entity.Shipping;
import edu.mum.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sushan on 8/15/2017.
 */
@Service
public class ShippingService {
   
    @Autowired
    private ShippingRepository shippingRepository;

    public Shipping save(Shipping shipping) {
        return shippingRepository.save(shipping);
    }


    public Shipping findById(Integer id) {
        Shipping shipping = shippingRepository.findOne(id);
        return shipping;
    }

    public void remove(Shipping shipping) {
        shippingRepository.delete(shipping);
    }

    public List<Shipping> getAll() {
        return (List<Shipping>) shippingRepository.findAll();
    }
}

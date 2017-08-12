package edu.mum.service;

import edu.mum.entity.Address;
import edu.mum.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AddressService {

    @Autowired
    AddressRepository repository;

    public void save(Address address) {
        repository.save(address);
    }


    public Address findById(Integer id) {
        Address p = repository.findOne(id);
        return p;
    }

    public void remove(Address address) {
        repository.delete(address);
    }

    public List<Address> getAll() {
        return (List<Address>) repository.findAll();
    }
}

package edu.mum.service;

import edu.mum.entity.GeneratedAmount;
import edu.mum.repository.GeneratedAmountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GeneratedAmountService {

    @Autowired
    GeneratedAmountRepository repository;

    public void save(GeneratedAmount generatedAmount) {
        repository.save(generatedAmount);
    }


    public GeneratedAmount findById(Integer id) {
        GeneratedAmount p = repository.findOne(id);
        return p;
    }

    public void remove(GeneratedAmount generatedAmount) {
        repository.delete(generatedAmount);
    }

    public List<GeneratedAmount> getAll() {
        return (List<GeneratedAmount>) repository.findAll();
    }
}

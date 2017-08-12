package edu.mum.service;
import java.util.*;
import edu.mum.entity.User;
import edu.mum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public void save(User user) {
        repository.save(user);
    }


    public User findById(Integer id) {
        User p = repository.findOne(id);
        return p;
    }

    public void remove(User person) {
        repository.delete(person);
    }

    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }
}

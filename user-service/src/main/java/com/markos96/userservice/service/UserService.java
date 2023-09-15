package com.markos96.userservice.service;

import com.markos96.userservice.entity.User;
import com.markos96.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public List<User> getAllUsers(){
        if(userRepository.findAll().isEmpty()){
            throw new RuntimeException("No hay usuarios en la lista");
        }
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id){
        if(userRepository.findById(id).isEmpty()){
            throw new RuntimeException("No existe el usuario ingresado");
        }
        return Optional.ofNullable(userRepository.findById(id)
                .orElse(null));
    }

    public User saveUser(User user){
        User newUser = userRepository.save(user);
        return newUser;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

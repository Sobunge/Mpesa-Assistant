package com.mpesa.main.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user) {

        userRepository.save(user);
    }

    public void updateUser(User user) {

        if (userRepository.existsById(user.getIdNumber())) {

            userRepository.deleteById(user.getIdNumber());

            userRepository.save(user);
        }

    }

    public void deleteUser(User user) {

        userRepository.deleteById(user.getIdNumber());
    }

    public void users(){
    
        
    }
}

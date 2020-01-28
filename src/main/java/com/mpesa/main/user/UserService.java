package com.mpesa.main.user;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addAdminUser(User user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role role = new Role("ADMIN",user);
        
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRole(roles);
        
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

    public boolean userPresent(User user) {
    
        return userRepository.existsById(user.getIdNumber());
    }
    
  
}

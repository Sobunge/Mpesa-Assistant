package com.mpesa.main.user;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersRestController {

    @Autowired
    UserService userService;

    @GetMapping("mpesa/users")

    public List getAllUsers(Principal principal) {

        int id = Integer.parseInt(principal.getName());

        List<User> users = new ArrayList<>();

        users.addAll(userService.findAll());
        User user = userService.getUser(id);

        List<User> allUsers = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {

            if (user.getIdNumber() != (users.get(i).getIdNumber())) {
                allUsers.add(users.get(i));
            }
        }

        return allUsers;
    }
    
    
}

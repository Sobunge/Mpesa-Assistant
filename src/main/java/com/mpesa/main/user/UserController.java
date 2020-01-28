package com.mpesa.main.user;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {

    @Autowired
    UserService userService;
    
    @GetMapping("/register")
    public String addUser(Model model) {

        model.addAttribute("user", new User());
        
        return "register";
    }
    
    @PostMapping("/register")
    public String processRegistration(@Valid User user, BindingResult bindingResult, Model model){
    
        if(bindingResult.hasErrors()){
        
            return "register";
        }
        
        if(userService.userPresent(user)){
        
            model.addAttribute("exists", "A user with the id number entered already exists");
            
            return "register";
        }
        
        userService.addAdminUser(user);
        
        model.addAttribute("success", user.getFirstName() + " successfully added");
        
        return "login";
    }
    
   
            
}

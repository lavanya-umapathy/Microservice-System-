package com.example.rest.demo_user.contoller;

import com.example.rest.demo_user.entity.User;
import com.example.rest.demo_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping("/")
    public User addUserDetail(@RequestBody User user) {

        return userService.saveUserDetails(user);
    }


    @GetMapping("/{id}")
    public Map<String,Object> getUserById(@PathVariable Long id) {
        return userService.getUserWithDepartment(id);
    }
}






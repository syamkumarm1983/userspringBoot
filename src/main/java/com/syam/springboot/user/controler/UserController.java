package com.syam.springboot.user.controler;

import com.syam.springboot.user.model.User;
import com.syam.springboot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id){
        User u = userService.getUser(id);
        System.out.println(u);
        return u;
    }

    @PutMapping("/addUser")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping("/AllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping("/updateUser")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/removeUser/{id}")
    public void removeUser(@PathVariable int id) {
        userService.removeeUser(id);
    }
}

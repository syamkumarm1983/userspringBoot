package com.syam.springboot.user.controler;

import com.syam.springboot.user.model.LocalUser;
import com.syam.springboot.user.service.LocalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocalUserController {

    @Autowired
    LocalUserService localUserService;

    @GetMapping("/user/{id}")
    public LocalUser getUser(@PathVariable int id){
        LocalUser u = localUserService.getUser(id);
        System.out.println(u);
        return u;
    }

    @PutMapping("/addUser")
    public void addUser(@RequestBody LocalUser localUser) {
        localUserService.addUser(localUser);
    }

    @GetMapping("/AllUsers")
    public List<LocalUser> getAllUsers() {
        return localUserService.getAllUsers();
    }
    
    @PostMapping("/updateUser")
    public void updateUser(@RequestBody LocalUser localUser) {
        localUserService.updateUser(localUser);
    }

    @DeleteMapping("/removeUser/{id}")
    public void removeUser(@PathVariable int id) {
        localUserService.removeeUser(id);
    }
}

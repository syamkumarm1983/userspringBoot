package com.syam.springboot.user.controler;

import com.syam.springboot.user.model.LocalUser;
import com.syam.springboot.user.service.LocalUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class LocalUserController {

    @Autowired
    LocalUserService localUserService;

    @GetMapping("/user/{id}")
    public LocalUser getUser(@Valid @PathVariable int id){
        LocalUser u = localUserService.getUser(id);
        System.out.println(u);
        if(u == null ){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return u;
    }

    @PutMapping("/addUser")
    public void addUser(@Valid @RequestBody LocalUser localUser) {
        localUserService.addUser(localUser);
    }

    @GetMapping("/AllUsers")
    public List<LocalUser> getAllUsers() {
        return localUserService.getAllUsers();
    }
    
    @PostMapping("/updateUser")
    public void updateUser(@Valid @RequestBody LocalUser localUser) {
        localUserService.updateUser(localUser);
    }

    @DeleteMapping("/removeUser/{id}")
    public void removeUser(@Valid @PathVariable int id) {

        if (!localUserService.removeeUser(id) ) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
    }
}

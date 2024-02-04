package com.syam.springboot.user.controler;

import com.syam.springboot.user.dao.DBUser;
import com.syam.springboot.user.model.DBUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class DBUserController {

    @Autowired
    private DBUserRepository dbuesrRepository;


    @GetMapping("/dbuser/{email}")
    public List<DBUser> getDbUser(@PathVariable("email") String email) {
        return dbuesrRepository.findByemail(email);
    }

    @GetMapping("/getAlldbUser")
    public List<DBUser> getAllDbUser () {
        return dbuesrRepository.findAll();
    }

    @PutMapping("/addDbuser")
    public DBUser addDbUser(@RequestBody DBUser user) {
        user.setID(UUID.randomUUID());
        return dbuesrRepository.save(user);
    }

    @PostMapping("/updateDbuser")
    public DBUser updateDbUser(@RequestBody DBUser user) {
        return dbuesrRepository.save(user);
    }

    @DeleteMapping("/removeDbuser/{email}")
    public void deleDbuser(@PathVariable("email") String email) {
        dbuesrRepository.deleteByemail(email);
    }
}

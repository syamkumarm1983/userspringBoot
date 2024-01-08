package com.syam.springboot.user.controler;

import com.syam.springboot.user.dao.DBUser;
import com.syam.springboot.user.model.DBUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DBUserController {

    @Autowired
    private DBUserRepository dbuesrRepository;


    @GetMapping("/dbuser/{id}")
    public List<DBUser> getDbUser(@PathVariable("id") int id) {
        return dbuesrRepository.findAllByid(id);
    }

    @GetMapping("/getAlldbUser")
    public List<DBUser> getAllDbUser () {
        return dbuesrRepository.findAll();
    }

    @PutMapping("/addDbuser")
    public DBUser addDbUser(@RequestBody DBUser user) {
        return dbuesrRepository.save(user);
    }

    @DeleteMapping("/removeDbuser/{id}")
    public void deleDbuser(@PathVariable("id") int id) {
        dbuesrRepository.deleteById(id);
    }
}

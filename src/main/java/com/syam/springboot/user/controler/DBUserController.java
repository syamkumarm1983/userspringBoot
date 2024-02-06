package com.syam.springboot.user.controler;

import com.syam.springboot.user.dao.DBUser;
import com.syam.springboot.user.model.DBUserRepository;
import com.syam.springboot.user.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DBUserController {

    @Autowired
    private DBUserRepository dbuesrRepository;

    @Autowired
    KafkaProducer myproducer;

    @GetMapping("/dbuser/{email}")
    public List<DBUser> getDbUser(@PathVariable("email") String email) {
        return dbuesrRepository.findByemail(email);
    }

    @GetMapping("/getAlldbUser")
    public List<DBUser> getAllDbUser () {
        return dbuesrRepository.findAll();
    }

    @PutMapping("/addDbuser")
    public ResponseEntity<String> addDbUser(@RequestBody String user) {
        myproducer.sendMessage("userinsert-events",user);
        return ResponseEntity.ok("Message sent to the topic to add user userinsert-events "+user.toString());
        }

    @PostMapping("/updateDbuser")
    public ResponseEntity<String> updateDbUser(@RequestBody String user) {
        myproducer.sendMessage("userupdate-events",user);
        return ResponseEntity.ok("User Update event sent to topic userupdate-events"+user.toString());
    }

    @DeleteMapping("/removeDbuser/{email}")
    public void deleDbuser(@PathVariable("email") String email) {
        myproducer.sendMessage("userdelete-events",email);
    }
}

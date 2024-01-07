package com.syam.springboot.user.service;

import com.syam.springboot.user.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    List<User> users;

    public UserService() {
        users = new ArrayList<>();
        User u1 = new User(1, "Syam", "syam@user.com");
        User u2 = new User(2, "Kumar", "kumar@user.com");
        User u3 = new User(3, "Leela", "leela@user.com");
        User u4 = new User(4, "Sai", "sai@user.com");
        User u5 = new User(5, "Kapil", "kapil@user.com");
        users.addAll(Arrays.asList(u1, u2, u3, u4, u5));
    }

    public User getUser(int id) {
        Optional optional = Optional.empty();
        return users.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void updateUser(User user) {
        users.stream().filter(s -> s.getId() == user.getId()).peek(s -> {
            s.setEmail(user.getEmail());
            s.setName(user.getName());
        }).findFirst();
    }

    public void removeeUser(int id) {
        users.removeIf(s -> s.getId() == id);
    }
}

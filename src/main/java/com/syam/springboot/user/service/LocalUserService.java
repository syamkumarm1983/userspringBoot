package com.syam.springboot.user.service;

import com.syam.springboot.user.model.LocalUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LocalUserService {

    List<LocalUser> localUsers;

    public LocalUserService() {
        localUsers = new ArrayList<>();
        LocalUser u1 = new LocalUser(1, "Syam", "syam@user.com");
        LocalUser u2 = new LocalUser(2, "Kumar", "kumar@user.com");
        LocalUser u3 = new LocalUser(3, "Leela", "leela@user.com");
        LocalUser u4 = new LocalUser(4, "Sai", "sai@user.com");
        LocalUser u5 = new LocalUser(5, "Kapil", "kapil@user.com");
        localUsers.addAll(Arrays.asList(u1, u2, u3, u4, u5));
    }

    public LocalUser getUser(int id) {
        Optional optional = Optional.empty();
        return localUsers.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }

    public void addUser(LocalUser localUser) {
        localUsers.add(localUser);
    }

    public List<LocalUser> getAllUsers() {
        return localUsers;
    }

    public void updateUser(LocalUser localUser) {
        localUsers.stream().filter(s -> s.getId() == localUser.getId()).peek(s -> {
            s.setEmail(localUser.getEmail());
            s.setName(localUser.getName());
        }).findFirst();
    }

    public boolean removeeUser(int id) {
        return localUsers.removeIf(s -> s.getId() == id);
    }
}

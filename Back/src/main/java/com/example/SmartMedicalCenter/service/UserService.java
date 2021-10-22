package com.example.SmartMedicalCenter.service;

import com.example.SmartMedicalCenter.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User update(User user,String username);
    User delete(String username);
    User getUser(String username);
    List<User> getUsers();
}

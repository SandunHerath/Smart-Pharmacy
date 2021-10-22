package com.example.SmartMedicalCenter.service;

import com.example.SmartMedicalCenter.Repository.UserRepository;
import com.example.SmartMedicalCenter.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImplementation implements UserService, UserDetailsService {
    private final UserRepository userRepo;

    private final PasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepo.findByUsername(username);
        if (user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        }else {
            log.info("User found in the database: {}",username);
        }
        Collection<SimpleGrantedAuthority> authorities= new ArrayList<>();

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving new user to database",user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }



    @Override
    public User getUser(String username) {
        log.info("Fetching user {}",username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching All Users");
        return userRepo.findAll();
    }


    @Override
    public User update(User user, String username) {
        User user1 = userRepo.findByUsername(username);
        if(user1 != null){
            user1.setName(user.getName());
            user1.setPassword(user.getPassword());
            user1.setUsername(user.getUsername());
            return userRepo.save(user1);
        }else {
            log.error("User not found in the database");
            return null;
        }
    }

    @Override
    public User delete(String username) {
        User user = userRepo.findByUsername(username);
        if(user != null){
            userRepo.delete(user);
            return user;
        }else {
            log.error("User not found in the database");
            return null;
        }
    }
}

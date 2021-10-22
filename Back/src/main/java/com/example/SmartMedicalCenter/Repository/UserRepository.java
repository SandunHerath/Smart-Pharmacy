package com.example.SmartMedicalCenter.Repository;

import com.example.SmartMedicalCenter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
        User findByUsername(String username);
}

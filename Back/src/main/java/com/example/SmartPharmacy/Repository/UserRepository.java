package com.example.SmartPharmacy.Repository;

import com.example.SmartPharmacy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}

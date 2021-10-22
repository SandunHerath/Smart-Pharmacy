package com.example.SmartPharmacy.Repository;

import com.example.SmartPharmacy.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}

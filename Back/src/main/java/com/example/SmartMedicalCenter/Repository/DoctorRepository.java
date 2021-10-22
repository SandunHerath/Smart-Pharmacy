package com.example.SmartMedicalCenter.Repository;

import com.example.SmartMedicalCenter.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}

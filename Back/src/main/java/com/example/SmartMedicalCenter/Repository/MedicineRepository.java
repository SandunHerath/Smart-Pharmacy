package com.example.SmartMedicalCenter.Repository;

import com.example.SmartMedicalCenter.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {

}

package com.example.SmartMedicalCenter.service;

import com.example.SmartMedicalCenter.model.Medicine;

import java.util.List;

public interface MedicineService {
    Medicine SaveMedicine(Medicine medicine);
    Medicine getSingleMedicine(Long id);
    Medicine updateMedicine(Medicine medicine,Long id);
    Medicine updateMedicineImage(String image,Long id);
    void deleteMedicine(Long id);
    List<Medicine> getMedicines();
}

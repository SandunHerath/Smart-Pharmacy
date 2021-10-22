package com.example.SmartMedicalCenter.service;

import com.example.SmartMedicalCenter.model.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor SaveDoctor(Doctor doctor);
    Doctor getSingleDoctor(Long id);
    Doctor updateDoctor(Doctor doctor,Long id);
    Doctor updateDoctorImage(String image,Long id);
    void deleteDoctor(Long id);
    List<Doctor> getDoctors();
}

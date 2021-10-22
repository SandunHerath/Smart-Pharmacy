package com.example.SmartMedicalCenter.service;

import com.example.SmartMedicalCenter.Repository.DoctorRepository;
import com.example.SmartMedicalCenter.model.Doctor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DoctorServiceImplementation implements DoctorService{

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor SaveDoctor(Doctor doctor) {
        log.info("Saving new Product to database",doctor.getName());

        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getSingleDoctor(Long id) {
        log.info("Fetching doctor {}",id);
        return doctorRepository.findById(id).get();
    }

    @Override
    public Doctor updateDoctor(Doctor doctor, Long id) {
        Doctor existing= doctorRepository.findById(id).get();
        if(existing !=null){
            existing.setName(doctor.getName());
            existing.setHospital(doctor.getHospital());
            existing.setGender(doctor.getGender());
            existing.setCategory(doctor.getCategory());
            return doctorRepository.save(existing);
        }else {
            log.error("Product not found in the database");
            return null;
        }
    }

    @Override
    public Doctor updateDoctorImage(String image, Long id) {
        Doctor existing= doctorRepository.findById(id).get();
        if(existing !=null){
            existing.setImage(image);

        }
        return doctorRepository.save(existing);
    }

    @Override
    public void deleteDoctor(Long id) {
        Doctor doctor= doctorRepository.findById(id).get();
        if(doctor !=null){
            doctorRepository.deleteById(id);
        }
    }

    @Override
    public List<Doctor> getDoctors() {
        log.info("Fetching All Products");
        return doctorRepository.findAll();
    }
}

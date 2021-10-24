package com.example.SmartMedicalCenter.service;

import com.example.SmartMedicalCenter.Repository.MedicineRepository;
import com.example.SmartMedicalCenter.model.Medicine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MedicineServiceImplementation implements MedicineService{
    private final MedicineRepository medicineRepository;
    @Override
    public Medicine SaveMedicine(Medicine medicine) {
        log.info("Saving new Product to database",medicine.getName());

        return medicineRepository.save(medicine);
    }

    @Override
    public Medicine getSingleMedicine(Long id) {
        log.info("Fetching product {}",id);
        System.out.println("_________________________________");
        Optional<Medicine> m = medicineRepository.findById(id);
            System.out.println(m);

        if(m.isPresent()){
            Medicine newMedicine = m.get();
            return newMedicine;
        }else{
            System.out.println("_________________________________");
            return null;
        }

    }

    @Override
    public Medicine updateMedicine(Medicine medicine, Long id) {
        Medicine existing= medicineRepository.findById(id).get();
        if(existing !=null){
            existing.setName(medicine.getName());
            existing.setPrice(medicine.getPrice());
            existing.setDescription(medicine.getDescription());
            existing.setImage(medicine.getImage());
            existing.setCategory(medicine.getCategory());

            return medicineRepository.save(existing);
        }else {
            log.error("Product not found in the database");
            return null;
        }
    }

    @Override
    public Medicine updateMedicineImage(String image, Long id) {
        Medicine existing= medicineRepository.findById(id).get();
        if(existing !=null){
            existing.setImage(image);

        }
        return medicineRepository.save(existing);
    }

    @Override
    public void deleteMedicine(Long id) {
       Medicine product= medicineRepository.findById(id).get();
        if(product !=null){
            medicineRepository.deleteById(id);
        }
    }

    @Override
    public List<Medicine> getMedicines() {
        log.info("Fetching All Products");
        return medicineRepository.findAll();
    }
}

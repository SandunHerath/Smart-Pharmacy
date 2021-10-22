package com.example.SmartMedicalCenter.api;

import com.example.SmartMedicalCenter.model.Medicine;
import com.example.SmartMedicalCenter.service.MedicineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
@RestController
@RequestMapping("/api/medicine")
@RequiredArgsConstructor
public class MedicineResource {
    private final MedicineService medicineService;

    public static final String DIRECTORY = System.getProperty("user.dir")+ "/src/main/resources/Uploads";
    @GetMapping("")
    public ResponseEntity<List<Medicine>> getProducts(){
        return ResponseEntity.ok().body(medicineService.getMedicines());
    }
    @PostMapping("/add")
    public ResponseEntity<Medicine>saveProduct(@RequestBody Medicine medicine)  {
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/products/add").toUriString());
        return ResponseEntity.created(uri).body(medicineService.SaveMedicine(medicine));
    }
    @PostMapping("/img/{id}")
    public ResponseEntity<Medicine> saveImg(@RequestParam("file") MultipartFile multipartFile, @PathVariable("id")Long id) throws IOException {

        StringBuffer stringBuffer= new StringBuffer();
        String filename= id+multipartFile.getOriginalFilename();
        Path filePath = Paths.get(DIRECTORY,filename);
        Files.write(filePath,multipartFile.getBytes());
        String path= filePath.toString();
        return ResponseEntity.ok().body(medicineService.updateMedicineImage(path,id));
    }
    @GetMapping("{id}")
    public ResponseEntity<Medicine>getSingleProduct(@PathVariable("id")Long id){
        return ResponseEntity.ok().body(medicineService.getSingleMedicine(id));
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Medicine>updateProduct(@PathVariable("id")Long id,@RequestBody Medicine medicine){
        return ResponseEntity.ok().body(medicineService.updateMedicine(medicine,id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Medicine>deleteProduct(@PathVariable("id")Long id){
        medicineService.deleteMedicine(id);
        return ResponseEntity.ok().build();
    }
}

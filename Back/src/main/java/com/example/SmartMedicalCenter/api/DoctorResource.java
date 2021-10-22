package com.example.SmartMedicalCenter.api;

import com.example.SmartMedicalCenter.model.Doctor;
import com.example.SmartMedicalCenter.service.DoctorService;
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
@RequestMapping("/api/doctor")
@RequiredArgsConstructor
public class DoctorResource {
    private final DoctorService  doctorService;
    public static final String DIRECTORY = System.getProperty("user.dir")+ "/src/main/resources/Uploads";

    @GetMapping("")
    public ResponseEntity<List<Doctor>> getProducts(){
        return ResponseEntity.ok().body(doctorService.getDoctors());
    }
    @PostMapping("/add")
    public ResponseEntity<Doctor>saveProduct(@RequestBody Doctor doctor)  {
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/products/add").toUriString());
        return ResponseEntity.created(uri).body(doctorService.SaveDoctor(doctor));
    }
    @PostMapping("/img/{id}")
    public ResponseEntity<Doctor> saveImg(@RequestParam("file") MultipartFile multipartFile, @PathVariable("id")Long id) throws IOException {

        StringBuffer stringBuffer= new StringBuffer();
        String filename= id+multipartFile.getOriginalFilename();
        Path filePath = Paths.get(DIRECTORY,filename);
        Files.write(filePath,multipartFile.getBytes());
        String path= filePath.toString();
        return ResponseEntity.ok().body(doctorService.updateDoctorImage(path,id));
    }
    @GetMapping("{id}")
    public ResponseEntity<Doctor>getSingleProduct(@PathVariable("id")Long id){
        return ResponseEntity.ok().body(doctorService.getSingleDoctor(id));
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Doctor>updateProduct(@PathVariable("id")Long id,@RequestBody Doctor doctor){
        return ResponseEntity.ok().body(doctorService.updateDoctor(doctor,id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Doctor>deleteProduct(@PathVariable("id")Long id){
      doctorService.deleteDoctor(id);
        return ResponseEntity.ok().build();
    }
}

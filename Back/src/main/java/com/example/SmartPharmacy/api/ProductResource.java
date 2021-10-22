package com.example.SmartPharmacy.api;

import com.example.SmartPharmacy.model.Products;
import com.example.SmartPharmacy.service.ProductService;
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
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductResource {
    private final ProductService productService;

    public static final String DIRECTORY = System.getProperty("user.dir")+ "/src/main/resources/Uploads";
    @GetMapping("")
    public ResponseEntity<List<Products>> getProducts(){
        return ResponseEntity.ok().body(productService.getProducts());
    }
    @PostMapping("/add")
    public ResponseEntity<Products>saveProduct(@RequestBody Products product)  {
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/products/add").toUriString());
        return ResponseEntity.created(uri).body(productService.SaveProduct(product));
    }
    @PostMapping("/img/{id}")
    public ResponseEntity<Products> saveImg(@RequestParam("file") MultipartFile multipartFile, @PathVariable("id")Long id) throws IOException {

        StringBuffer stringBuffer= new StringBuffer();
        String filename= id+multipartFile.getOriginalFilename();
        Path filePath = Paths.get(DIRECTORY,filename);
        Files.write(filePath,multipartFile.getBytes());
        String path= filePath.toString();
        return ResponseEntity.ok().body(productService.updateProductImage(path,id));
    }
    @GetMapping("{id}")
    public ResponseEntity<Products>getSingleProduct(@PathVariable("id")Long id){
        return ResponseEntity.ok().body(productService.getSingleProduct(id));
    }
    @PutMapping("update/{id}")
    public ResponseEntity<Products>updateProduct(@PathVariable("id")Long id,@RequestBody Products product){
        return ResponseEntity.ok().body(productService.updateProduct(product,id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Products>deleteProduct(@PathVariable("id")Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}

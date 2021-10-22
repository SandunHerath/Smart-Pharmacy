package com.example.SmartPharmacy.service;

import com.example.SmartPharmacy.Repository.ProductRepository;
import com.example.SmartPharmacy.model.Products;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductServiceImplementation implements ProductService{
    private final ProductRepository productRepository;
    @Override
    public Products SaveProduct(Products product) {
        log.info("Saving new Product to database",product.getName());

        return productRepository.save(product);
    }

    @Override
    public Products updateProductImage(String image, Long id) {
        Products existing= productRepository.findById(id).get();
        if(existing !=null){
            existing.setImage(image);

        }
        return productRepository.save(existing);
    }

    @Override
    public Products getSingleProduct(Long id) {
        log.info("Fetching product {}",id);
        return productRepository.findById(id).get();
    }

    @Override
    public Products updateProduct(Products product, Long id) {
        Products existing= productRepository.findById(id).get();
        if(existing !=null){
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setDescription(product.getDescription());
            existing.setImage(product.getImage());
            existing.setCategory(product.getCategory());

            return productRepository.save(existing);
        }else {
            log.error("Product not found in the database");
            return null;
        }
    }



    @Override
    public void deleteProduct(Long id) {
        Products product= productRepository.findById(id).get();
        if(product !=null){
            productRepository.deleteById(id);
        }

    }

    @Override
    public List<Products> getProducts() {
        log.info("Fetching All Products");
        return productRepository.findAll();
    }
}

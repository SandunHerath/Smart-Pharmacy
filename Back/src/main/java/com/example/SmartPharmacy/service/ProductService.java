package com.example.SmartPharmacy.service;

import com.example.SmartPharmacy.model.Products;

import java.util.List;

public interface ProductService {
    Products SaveProduct(Products product);
    Products getSingleProduct(Long id);
    Products updateProduct(Products product,Long id);
    Products updateProductImage(String image,Long id);
    void deleteProduct(Long id);
    List<Products>getProducts();
}
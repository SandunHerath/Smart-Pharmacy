package com.example.SmartPharmacy.Repository;

import com.example.SmartPharmacy.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,Long> {
}

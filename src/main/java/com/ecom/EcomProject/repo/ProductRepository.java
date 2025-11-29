package com.ecom.EcomProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.EcomProject.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

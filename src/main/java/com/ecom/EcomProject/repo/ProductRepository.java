package com.ecom.EcomProject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.EcomProject.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p from Product p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :searchedQuery, '%')) OR " +
            "LOWER(p.description) LIKE LOWER(CONCAT('%', :searchedQuery, '%')) OR " +
            "LOWER(p.brand) LIKE LOWER(CONCAT('%', :searchedQuery, '%')) OR " +
            "LOWER(p.category) LIKE LOWER (CONCAT('%', :searchedQuery, '%'))")
    List<Product> searchProductsByQuery(String searchedQuery);

}

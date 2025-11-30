package com.ecom.EcomProject.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.EcomProject.model.Product;
import com.ecom.EcomProject.repo.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int productId) {
        return productRepo.findById(productId).orElse(null);
    }

    public Product addProduct(Product product, String imageUrl) throws IOException {
        product.setImageUrl(imageUrl);

        return productRepo.save(product);
    }

    public Product updateProductById(int productId, Product product, String imageFileUrl) throws IOException {
        product.setImageUrl(imageFileUrl);

        return productRepo.save(product);
    }

    public void deleteProductById(int productId) {
        productRepo.deleteById(productId);
    }

    public List<Product> searchProductsByQuery(String searchedQuery) {
        return productRepo.searchProductsByQuery(searchedQuery);
    }

}

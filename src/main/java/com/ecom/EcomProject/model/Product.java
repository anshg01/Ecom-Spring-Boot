package com.ecom.EcomProject.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Product {

    @Id
    private int id;
    private String name;
    private String brand;
    private double price;
    private String description;
    private String category;
    private String imageUrl;
    private Date releaseDate;
    private boolean inStock;
    private int quantity;
    private double rating;

}

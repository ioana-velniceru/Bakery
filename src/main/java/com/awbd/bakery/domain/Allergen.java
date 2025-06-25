package com.awbd.bakery.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;



@Data
@Entity
public class Allergen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "allergens")
    private List<Product> products;

}

package com.awbd.bakery.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Boolean hasSugar;
    private Boolean isVegan;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Info info;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(name = "product_allergen",
            inverseJoinColumns =@JoinColumn(name="allergen_id",referencedColumnName = "id"),
            joinColumns =@JoinColumn(name="product_id",referencedColumnName="id"))
    private List<Allergen> allergens;

    @Enumerated(value = EnumType.STRING)
    private Currency currency;

}

package com.awbd.bakery.dtos;


import com.awbd.bakery.domain.Allergen;
import com.awbd.bakery.domain.Currency;

import com.awbd.bakery.domain.Info;
import com.awbd.bakery.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private Boolean hasSugar;
    private Boolean isVegan;
    private Info info;
    private Category category;
    private List<Allergen> allergens;
    private Currency currency;

}

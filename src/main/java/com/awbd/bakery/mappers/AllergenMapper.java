package com.awbd.bakery.mappers;

import com.awbd.bakery.domain.Allergen;
import com.awbd.bakery.dtos.AllergenDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/*
@Component
public class AllergenMapper {
    public AllergenDTO toDto(Allergen allergen) {
        Long id = allergen.getId();
        String name= allergen.getName();
        return new AllergenDTO(id, name);
    }

    public Allergen toAllergen(AllergenDTO allergenDTO) {
        Allergen allergen = new Allergen();
        allergen.setId(allergenDTO.getId());
        allergen.setName(allergenDTO.getName());
        return allergen;
    }
}
 */

@Mapper(componentModel = "spring")
public interface AllergenMapper {
    public AllergenDTO toDto(Allergen allergen);

    public Allergen toAllergen(AllergenDTO allergenDTO);
}
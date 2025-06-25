package com.awbd.bakery.mappers;

import com.awbd.bakery.domain.Category;
import com.awbd.bakery.dtos.CategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CategoryMapper {
    CategoryDTO toDto (Category category);
    Category toCategory(CategoryDTO categoryDTO);
}

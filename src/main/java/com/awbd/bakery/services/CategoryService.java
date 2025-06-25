package com.awbd.bakery.services;

import com.awbd.bakery.dtos.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<CategoryDTO> findAll();
    CategoryDTO findById(Long l);
    CategoryDTO save(CategoryDTO category);
    void deleteById(Long id);

}

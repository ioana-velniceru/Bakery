package com.awbd.bakery.services;

import com.awbd.bakery.domain.Category;
import com.awbd.bakery.dtos.CategoryDTO;
import com.awbd.bakery.mappers.CategoryMapper;
import com.awbd.bakery.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDTO> findAll(){
        List<Category> categories = new LinkedList<>();
        categoryRepository.findAll().iterator().forEachRemaining(categories::add);

        return categories.stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO findById(Long l) {
        Optional<Category> categoryOptional = categoryRepository.findById(l);
        if (!categoryOptional.isPresent()) {
            throw new RuntimeException("Category not found!");
        }

        return categoryMapper.toDto(categoryOptional.get());
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDto) {
        Category savedCategory = categoryRepository.save(categoryMapper.toCategory(categoryDto));
        return categoryMapper.toDto(savedCategory);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }


}

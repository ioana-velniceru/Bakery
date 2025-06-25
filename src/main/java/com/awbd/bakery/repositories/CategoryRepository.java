package com.awbd.bakery.repositories;

import com.awbd.bakery.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findByNameLike(String name);
    List<Category> findByIdIn(List<Long> ids);
}
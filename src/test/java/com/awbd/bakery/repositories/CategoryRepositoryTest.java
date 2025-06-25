package com.awbd.bakery.repositories;


import com.awbd.bakery.domain.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;


@DataJpaTest
@ActiveProfiles("h2")
@Slf4j
public class CategoryRepositoryTest {

    CategoryRepository categoryRepository;
    @Autowired
    CategoryRepositoryTest(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Test
    public void findByName() {
        List<Category> categories = categoryRepository.findByNameLike("%cake%");
        assertFalse(categories.isEmpty());
        log.info("findByNameLike ...");
        categories.forEach(category -> log.info(category.getName()));
    }

    @Test public void findByIds() {
        List<Category> categories = categoryRepository.findByIdIn(Arrays.asList(1L,2L));
        assertFalse(categories.isEmpty());
        log.info("findByIds ...");
        categories.forEach(category -> log.info(category.getName()));




    }

}

package com.awbd.bakery.repositories;

import com.awbd.bakery.domain.Currency;
import com.awbd.bakery.domain.Info;
import com.awbd.bakery.domain.Category;
import com.awbd.bakery.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("h2")
public class CascadeTypesTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void updateDescription(){
        Optional<Product> productOpt = productRepository.findById(1L);
        assertTrue(productOpt.isPresent());
        Product product = productOpt.get();
        product.getInfo().setDescription("Thin biscuit with cream filling");
        product.setCurrency(Currency.RON);

        productRepository.save(product);

        productOpt = productRepository.findById(1L);
        assertTrue(productOpt.isPresent());
        product = productOpt.get();
        assertEquals(Currency.RON, product.getCurrency());
        assertEquals("Thin biscuit with cream filling", product.getInfo().getDescription());

    }

    @Test
    public void insertProduct(){
        Product product = new Product();
        product.setId(4L);
        product.setName("Carrot Cake");
        product.setCurrency(Currency.RON);

        Info info = new Info();
        info.setId(4L);
        info.setProduct(product);
        info.setDescription("Cake with carrot filling");

        product.setInfo(info);

        productRepository.save(product);

        Optional<Product> productOpt = productRepository.findByName("Carrot Cake");
        assertTrue(productOpt.isPresent());
        product = productOpt.get();
        assertEquals(Currency.RON, product.getCurrency());
        assertEquals("Cake with carrot filling", product.getInfo().getDescription());

    }


    @Test
    public void updateCategory(){
        Optional<Product> productOpt = productRepository.findById(2L);
        assertTrue(productOpt.isPresent());
        Category category = productOpt.get().getCategory();
        category.setName("Themed cake");

        category.getProducts().forEach(prod -> prod.setCurrency(Currency.EUR));

        Product product = new Product();
        product.setId(5L);
        product.setName("Birthday Cake");
        product.setCurrency(Currency.EUR);
        category.getProducts().add(product);

        categoryRepository.save(category);

        Optional<Category> categoryOpt = categoryRepository.findById(2L);
        assertTrue(categoryOpt.isPresent());
        category = categoryOpt.get();
        category.getProducts().forEach(prod ->
            assertEquals(Currency.EUR, prod.getCurrency()));

    }


    @Test
    public void deleteCategory(){
        categoryRepository.deleteById(2L);
        Optional<Product> product = productRepository.findById(2L);

        //orphan removal true
        assertTrue(product.isEmpty());
    }

}

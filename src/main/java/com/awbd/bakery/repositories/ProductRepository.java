package com.awbd.bakery.repositories;

import com.awbd.bakery.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

    Optional<Product> findById (Long id);
    Optional<Product> findByName (String name);

    void deleteById(Long id);
    Product save(Product product);

    @Query("select p from Product p where p.category.id = ?1")
    List<Product> findByCategory(Long categoryId);

    @Query("select p from Product p where p.category.name = :name")
    List<Product> findByCategoryName(@Param("name") String categoryName);

}
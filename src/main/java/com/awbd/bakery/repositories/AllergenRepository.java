package com.awbd.bakery.repositories;
import com.awbd.bakery.domain.Allergen;
import org.springframework.data.repository.CrudRepository;

public interface AllergenRepository extends CrudRepository<Allergen, Long> {

}
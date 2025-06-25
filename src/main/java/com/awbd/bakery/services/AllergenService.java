package com.awbd.bakery.services;

import com.awbd.bakery.dtos.AllergenDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AllergenService {
    List<AllergenDTO> findAll();
    AllergenDTO findById(Long l);
    AllergenDTO save(AllergenDTO allergen);
    void deleteById(Long id);

}

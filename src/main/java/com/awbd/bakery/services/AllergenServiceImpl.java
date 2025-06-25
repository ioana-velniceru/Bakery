package com.awbd.bakery.services;

import com.awbd.bakery.domain.Allergen;
import com.awbd.bakery.dtos.AllergenDTO;
import com.awbd.bakery.mappers.AllergenMapper;
import com.awbd.bakery.repositories.AllergenRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AllergenServiceImpl implements AllergenService {
    
    private final AllergenRepository allergenRepository;
    private final AllergenMapper allergenMapper;
    
    AllergenServiceImpl(AllergenRepository allergenRepository, AllergenMapper allergenMapper){
        this.allergenRepository = allergenRepository;
        this.allergenMapper = allergenMapper;
    }

    @Override
    public List<AllergenDTO> findAll(){
        List<Allergen> allergens = new LinkedList<>();
        allergenRepository.findAll().iterator().forEachRemaining(allergens::add);

        return allergens.stream()
                .map(allergenMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AllergenDTO findById(Long l) {
        Optional<Allergen> allergenOptional = allergenRepository.findById(l);
        if (!allergenOptional.isPresent()) {
            throw new RuntimeException("Allergen not found!");
        }

        return allergenMapper.toDto(allergenOptional.get());
    }

    @Override
    public AllergenDTO save(AllergenDTO allergenDto) {
        Allergen savedAllergen = allergenRepository.save(allergenMapper.toAllergen(allergenDto));
        return allergenMapper.toDto(savedAllergen);
    }

    @Override
    public void deleteById(Long id) {
        allergenRepository.deleteById(id);
    }
    
    
}

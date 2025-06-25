package com.awbd.bakery.services;

import com.awbd.bakery.domain.Allergen;
import com.awbd.bakery.dtos.AllergenDTO;
import com.awbd.bakery.mappers.AllergenMapper;
import com.awbd.bakery.repositories.AllergenRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AllergenServiceTest {

    @Mock
    AllergenMapper allergenMapper;
    @Mock
    AllergenRepository allergenRepository;

    @InjectMocks
    AllergenServiceImpl allergenService;

    @Test
    public void findProducts() {
        List<Allergen> allergenList = new ArrayList<>();
        Allergen allergen = new Allergen();
        allergenList.add(allergen);

        when(allergenRepository.findAll()).thenReturn(allergenList);
        List<AllergenDTO> allergensDto = allergenService.findAll();
        assertEquals(1, allergensDto.size());
        verify(allergenRepository, times(1)).findAll();
    }
}

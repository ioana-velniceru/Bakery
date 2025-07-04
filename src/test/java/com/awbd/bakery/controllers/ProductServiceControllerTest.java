package com.awbd.bakery.controllers;

import com.awbd.bakery.domain.Product;
import com.awbd.bakery.dtos.ProductDTO;
import com.awbd.bakery.services.AllergenService;
import com.awbd.bakery.services.CategoryService;
import com.awbd.bakery.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceControllerTest {

    @Mock
    Model model;

    @Mock
    ProductService productService;

    @Mock
    AllergenService allergenService;

    @Mock
    CategoryService categoryService;

    @InjectMocks
    ProductController productController;

    @Test
    public void showById() {
        Long id = 1L;
        Product productTest;

        productTest = new Product();
        productTest.setId(id);

        ProductDTO productTestDTO = new ProductDTO();
        productTestDTO.setId(id);

        when(productService.findById(id)).thenReturn(productTestDTO);

        String viewName = productController.edit(id.toString(), model);
        assertEquals("productForm", viewName);
        verify(productService, times(1)).findById(id);

        ArgumentCaptor<ProductDTO> argumentCaptor = ArgumentCaptor.forClass(ProductDTO.class);
        verify(model, times(1))
                .addAttribute(eq("product"), argumentCaptor.capture() );

        ProductDTO productArg = argumentCaptor.getValue();
        assertEquals(productArg.getId(), productTestDTO.getId() );

    }
}
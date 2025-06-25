package com.awbd.bakery.services;

import com.awbd.bakery.dtos.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ProductService {
    List<ProductDTO> findAll();
    ProductDTO findById(Long l);
    ProductDTO save(ProductDTO product);
    void deleteById(Long id);

    void savePhotoFile(ProductDTO product, MultipartFile file);
}

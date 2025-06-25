package com.awbd.bakery.controllers;

import com.awbd.bakery.dtos.AllergenDTO;
import com.awbd.bakery.dtos.CategoryDTO;
import com.awbd.bakery.dtos.ProductDTO;
import com.awbd.bakery.services.AllergenService;
import com.awbd.bakery.services.CategoryService;
import com.awbd.bakery.services.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    AllergenService allergenService;
    CategoryService categoryService;

    public ProductController(ProductService productService, AllergenService allergenService, CategoryService categoryService) {
        this.productService = productService;
        this.allergenService = allergenService;
        this.categoryService = categoryService;
    }

    @RequestMapping("/form")
    public String productForm(Model model) {
        ProductDTO product = new ProductDTO();
        model.addAttribute("product",  product);
        List<AllergenDTO> allAllergens = allergenService.findAll();
        model.addAttribute("allAllergens", allAllergens );
        List<CategoryDTO> allCategories = categoryService.findAll();
        model.addAttribute("allCategories", allCategories);
        return "productForm";
    }


    @RequestMapping("")
    public String productList(Model model) {
        List<ProductDTO> products = productService.findAll();
        model.addAttribute("products", products);
        return "productList";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        ProductDTO productDTO = productService.findById(Long.valueOf(id));
        model.addAttribute("product", productDTO);

        List<AllergenDTO> allAllergens = allergenService.findAll();
        model.addAttribute("allAllergens", allAllergens );

        List<CategoryDTO> allCategories = categoryService.findAll();
        model.addAttribute("allCategories", allCategories);

        return "productForm";
    }


    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable String id){
        productService.deleteById(Long.valueOf(id));
        return "redirect:/products";
    }

    @PostMapping("")
    public String saveOrUpdate(@ModelAttribute ProductDTO product,
                               @RequestParam("imagefile") MultipartFile file){
        if (file.isEmpty())
            productService.save(product);
        else
            productService.savePhotoFile(product, file);


        return "redirect:/products" ;
    }


    @GetMapping("/getimage/{id}")
    public void downloadImage(@PathVariable String id, HttpServletResponse response) throws IOException {
        ProductDTO productDTO = productService.findById(Long.valueOf(id));

        if (productDTO.getInfo() != null) {


            if (productDTO.getInfo().getPhoto() != null) {
                byte[] byteArray = new byte[productDTO.getInfo().getPhoto().length];
                int i = 0;
                for (Byte wrappedByte : productDTO.getInfo().getPhoto()) {
                    byteArray[i++] = wrappedByte;
                }
                response.setContentType("image/jpeg");
                InputStream is = new ByteArrayInputStream(byteArray);
                try {
                    IOUtils.copy(is, response.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
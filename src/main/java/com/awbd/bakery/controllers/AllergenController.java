package com.awbd.bakery.controllers;

import com.awbd.bakery.dtos.AllergenDTO;
import com.awbd.bakery.services.AllergenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/allergens")
public class AllergenController {
    AllergenService allergenService;

    public AllergenController(AllergenService allergenService) {
        this.allergenService = allergenService;
    }

    @RequestMapping("")
    public String allergenList(Model model) {
        List<AllergenDTO> allergens = allergenService.findAll();
        model.addAttribute("allergens",allergens);
        return "allergenList";
    }

}
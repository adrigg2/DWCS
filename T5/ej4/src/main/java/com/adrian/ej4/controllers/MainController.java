package com.adrian.ej4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.adrian.ej4.Country;
import com.adrian.ej4.services.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class MainController {
    @Autowired
    private CountryService countryService;

    @GetMapping({ "/", "/home", "/index" })
    public String getIndex(Model model) {
        model.addAttribute("countryForm", new Country());
        model.addAttribute("countryList", countryService.getCountries());
        return "IndexView";
    }

    @PostMapping("/country")
    public String postMethodName(Country country, Model model) {
        if (country.getName().equals("null")) {
            return "redirect:/";
        }

        country = countryService.getCountry(country.getName());
        model.addAttribute("countryCapital", country.getCapital());
        model.addAttribute("countryPopulation", country.getPopulation());
        model.addAttribute("countryList", countryService.getCountries());
        model.addAttribute("countryForm", country);
        return "IndexView";
    }
    
}

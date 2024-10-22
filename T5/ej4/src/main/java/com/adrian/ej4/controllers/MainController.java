package com.adrian.ej4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.adrian.ej4.Country;
import com.adrian.ej4.services.CountryService;
import org.springframework.web.bind.annotation.GetMapping;


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
}

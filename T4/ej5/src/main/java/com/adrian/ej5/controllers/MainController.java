package com.adrian.ej5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.adrian.ej5.services.MathService;



@Controller
public class MainController {
    @Autowired
    private MathService mathService;

    private String errorTxt = null;

    @GetMapping({ "/", "/home", "/index" })
    public String getMethodName(Model model) {
        if (errorTxt != null) {
            model.addAttribute("errorTxt", errorTxt);
            errorTxt = null;
        }
        return "indexView";
    }
    

    @GetMapping("/calculateHypothenuse/{cat1}/{cat2}")
    public String showHypoth(@PathVariable String cat1, @PathVariable String cat2, Model model) {
        try {
            model.addAttribute("result", mathService.calcalutaHypothenuse(cat1, cat2));
            return "resultView";
        } catch (RuntimeException ex) {
            errorTxt = ex.getMessage();
            return "redirect:/";
        }
    }
}

package com.adrian.ej1_2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.adrian.ej1_2.services.OperationService;


@Controller
public class MainController {
    @Autowired
    private OperationService operationService;

    @GetMapping({ "/", "/home", "/index" })
    public String getIndex() {
        return "indexView";
    }
    
    @GetMapping("/operations/prime")
    public String getIsPrime(@RequestParam Integer number, Model model) {
        try {
            model.addAttribute("number", number);
            model.addAttribute("prime", operationService.isPrime(number));
            return "primeView";
        }
        catch (Exception e) {
            model.addAttribute("errorTxt", e.getMessage());
            return "errorView";
        }
    }
    
    @GetMapping("/operations/hypothenuse/{x}/{y}")
    public String getHypothenuse(@PathVariable Float x, @PathVariable Float y, Model model) {
        try {
            model.addAttribute("x", x);
            model.addAttribute("y", y);
            model.addAttribute("hypothenuse", operationService.calculateHypotenuse(x, y));
            return "hypothenuseView";
        }
        catch (Exception e) {
            model.addAttribute("errorTxt", e.getMessage());
            return "errorView";
        }
    }
    
    @GetMapping("/operations/divisors/{x}")
    public String getDivisors(@PathVariable Integer x, Model model) {
        try {
            model.addAttribute("x", x);
            model.addAttribute("divisors", operationService.calculateDivisors(x));
            return "divisorsView";
        }
        catch (Exception e) {
            model.addAttribute("errorTxt", e.getMessage());
            return "errorView";
        }
    }
}

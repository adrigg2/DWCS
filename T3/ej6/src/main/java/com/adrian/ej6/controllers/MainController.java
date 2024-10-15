package com.adrian.ej6.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MainController {
    public Integer firstOperand = 0;
    public Integer secondOperand = 0;
    public Integer result;
    public boolean firstOperandSelected = true;
    
    @GetMapping({ "/", "/home", "/index" })
    public String showCalculator(Model model) {
        model.addAttribute("firstOperand", firstOperand);
        model.addAttribute("secondOperand", secondOperand);
        model.addAttribute("firstOperandSelected", firstOperandSelected);
        model.addAttribute("result", result);
        return "calculatorView";
    }
    
    @GetMapping("/digit/{digit}")
    public String showNumber(@PathVariable Integer digit) {
        if (firstOperandSelected) {
            firstOperand = firstOperand * 10 + digit;
        } else {
            secondOperand  = secondOperand * 10 + digit;
        }
        return "redirect:/";
    }

    @GetMapping("/calculate")
    public String showCalculate(Model model) {
        result = firstOperand + secondOperand;
        return "redirect:/";
    }

    @GetMapping("/add")
    public String showAdd() {
        firstOperandSelected = false;
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String showClear() {
        firstOperand = 0;
        secondOperand = 0;
        firstOperandSelected = true;
        result = null;
        return "redirect:/";
    }
}

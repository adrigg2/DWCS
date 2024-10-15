package com.adrian.ej4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.adrian.ej4.services.CalculatorService;



@Controller
public class MainController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping({ "/", "/home", "/index" })
    public String showCalculator(Model model) {
        model.addAttribute("firstOperand", calculatorService.getFirstOperand());
        model.addAttribute("secondOperand", calculatorService.getSecondOperand());
        model.addAttribute("operationState", calculatorService.getOperationState());
        model.addAttribute("result", calculatorService.getResult());
        return "calculatorView";
    }
    
    @GetMapping("/digit/{digit}")
    public String showNumber(@PathVariable Integer digit) {
        calculatorService.setOperand(digit);
        return "redirect:/";
    }

    @GetMapping("/calculate")
    public String showCalculate(Model model) {
        calculatorService.add();
        return "redirect:/";
    }

    @GetMapping("/add")
    public String showAdd() {
        calculatorService.changeOperand(true);
        return "redirect:/";
    }
    
    @GetMapping("/substract")
    public String showSubstract() {
        calculatorService.changeOperand(false);
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String showClear() {
        calculatorService.clear();
        return "redirect:/";
    }
}

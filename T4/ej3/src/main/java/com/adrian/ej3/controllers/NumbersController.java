package com.adrian.ej3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.adrian.ej3.services.NumbersService;

@Controller
public class NumbersController {
    @Autowired
    private NumbersService numbersService;

    @GetMapping({ "/", "/list", "" })
    public String showList(Model model) {
        model.addAttribute("totalQuantity", numbersService.getList().size());
        model.addAttribute("numberList", numbersService.getList());
        return "listView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        numbersService.generateNumber();
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Integer id, Model model) {
        numbersService.removeNumber(id);
        return "redirect:/list";
    }
}

package com.adrian.ej4.controllers;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NumbersController {
    Random random = new Random();
    public Set<Integer> list = new LinkedHashSet<>();

    @GetMapping({ "/", "/list", "" })
    public String showList(Model model) {
        model.addAttribute("totalQuantity", list.size());
        model.addAttribute("numberList", list);
        return "listView";
    }

    @GetMapping("/new")
    public String showNew() {
        boolean added;
        do {
            added = list.add(random.nextInt(100) + 1);
        } while (!added);
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Integer id) {
        list.remove(id);
        return "redirect:/list";
    }
}

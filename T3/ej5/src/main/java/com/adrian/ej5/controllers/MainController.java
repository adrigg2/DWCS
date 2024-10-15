package com.adrian.ej5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class MainController {
    public Integer[] votes = new Integer[] {0, 0, 0};

    @GetMapping({ "/", "/home", "/index" })
    public String getIndex(Model model) {
        model.addAttribute("votes", votes);
        return "moviesView";
    }

    @GetMapping("/vote")
    public String getMethodName(@RequestParam String movie) {
        Integer vote = Integer.parseInt(movie);
        votes[vote]++;
        return "redirect:/home";
    }    
}

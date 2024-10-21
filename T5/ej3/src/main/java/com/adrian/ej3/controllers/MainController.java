package com.adrian.ej3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import com.adrian.ej3.VoteForm;
import com.adrian.ej3.services.VoteService;

import jakarta.validation.Valid;



@Controller
public class MainController {
    @Autowired
    private VoteService voteService;

    public Integer[] votes = new Integer[] {0, 0, 0};

    @GetMapping({ "/", "/home", "/index" })
    public String getIndex(Model model) {
        model.addAttribute("votes", votes);
        return "moviesView";
    }

    @GetMapping("/vote")
    public String getMethodName(@Valid VoteForm voteForm, BindingResult bindingResult) {
        
        return "redirect:/home";
    }    
}

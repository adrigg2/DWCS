package com.adrian.ej3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.adrian.ej3.VoteForm;
import com.adrian.ej3.services.VoteService;

import jakarta.validation.Valid;



@Controller
public class MainController {
    @Autowired
    private VoteService voteService;

    @GetMapping({ "/", "/home", "/index" })
    public String getIndex(Model model) {
        model.addAttribute("voteForm", new VoteForm());
        model.addAttribute("votes", voteService.getVotes());
        return "moviesView";
    }

    @PostMapping("/vote")
    public String getVote(@Valid VoteForm voteForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("votes", voteService.getVotes());
            return "moviesView";
        }

        Boolean voteRegistered = voteService.registerVote(voteForm.getEmail(), voteForm.getMovie());
        if (!voteRegistered) {
            model.addAttribute("voteError", "This email has already voted");
            model.addAttribute("votes", voteService.getVotes());
            return "moviesView";
        }

        return "redirect:/";
    }    
}

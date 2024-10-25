package com.adrian.ej5.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.adrian.ej5.ContactForm;
import com.adrian.ej5.services.EmailService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class MainController {
    @Autowired
    private EmailService service;
    private String messageBody = "Thank you for your continued support";
    private String messageSubject = "Thank you";

    private String txtError;

    @GetMapping({ "/", "/home", "/index" })
    public String getIndex(@RequestParam(required = false) String user, Model model) {
        if (user != null) {
            model.addAttribute("user", user);
        }
        model.addAttribute("currentDate", LocalDate.now().getYear());
        return "indexView";
    }

    @GetMapping("/palmares")
    public String getPalmares() {
        return "teamView";
    }
    
    @GetMapping("/galeria")
    public String getPhotos() {
        return "photosView";
    }

    @GetMapping("/contact")
    public String getContact(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        if (txtError != null) {
            model.addAttribute("txtError", txtError);
            txtError = null;
        }

        return "contactView";
    }

    @PostMapping("/send")
    public String postEmail(@Valid ContactForm contactForm, BindingResult bindingResult, @RequestParam MultipartFile file, Model model) {
        if (bindingResult.hasErrors()) {
            txtError = bindingResult.getAllErrors().toString();
            return "redirect:/contact";
        }

        String filePath = "";
        try {
            filePath = service.storeFile(file, contactForm.getDni());
        } catch (RuntimeException e) {
            txtError = e.getMessage();
            return "redirect:/contact";
        }

        try {
            service.SendEmail(contactForm.getEmail(), messageSubject, messageBody, filePath);
        } catch (RuntimeException e) {
            txtError = e.getMessage();
            return "redirect:/contact";
        }

        return "redirect:/";
    }    
}

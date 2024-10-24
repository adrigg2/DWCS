package com.adrian.ej5.controllers;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
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
        return "contactView";
    }
}

package com.adrian.ej2.controllers;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @GetMapping({ "/", "/home", "/index" })
    public String getIndex(Model model) {
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
}

package com.adrian.ej1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @GetMapping({ "/", "/home", "/index" })
    public String getIndex() {
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

package com.adrian.t2e2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class T2e2Controller {
    @GetMapping( {"", "/", "/index", "/home"} )
    public String getIndex() {
        return "index";
    }
    
}

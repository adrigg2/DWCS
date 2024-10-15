package com.adrian.ej1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.adrian.ej1.FormInfo;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class MainController {
    @GetMapping("/myForm")
    public String getMethodName(Model model) {
        model.addAttribute("formInfo", new FormInfo());
        return "formView";
    }

    @PostMapping("/myForm/submit")
    public String postMethodName(FormInfo formInfo, Model model) {
        formInfo.setName(formInfo.getName().toUpperCase());
        model.addAttribute("formInfo", formInfo);
        
        return "formSubmitView";
    }

}

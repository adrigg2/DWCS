package com.adrian.ej2.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.adrian.ej2.DateForm;
import com.adrian.ej2.State;
import com.adrian.ej2.services.DateService;



@Controller
public class MainController {
    @Autowired
    DateService dateService;


    @GetMapping("/")
    public String getMethodName(Model model) {
        model.addAttribute("dateForm", new DateForm());
        return "formView";
    }

    @PostMapping("/submit")
    public String postMethodName(DateForm dateForm, Model model) {
        LocalDate date1 = dateForm.getDate1().isBefore(dateForm.getDate2()) ? dateForm.getDate1() : dateForm.getDate2();
        LocalDate date2 = dateForm.getDate1().isBefore(dateForm.getDate2()) ? dateForm.getDate2() : dateForm.getDate1();


        switch (dateForm.getState()) {
            case State.COUNT_DAYS:
                dateForm.setDaysBetweenDates(dateService.countDays(date1, date2));
                break;
        
            case State.COUNT_LEAP_YEARS:
                dateForm.setLeapYears(dateService.countLeapYears(date1, date2));
                break;

            case State.COUNT_SUNDAYS:
                dateForm.setYearsStartOnSunday(dateService.countYearsStartOnSunday(date1, date2));
                break;
        }
        
        model.addAttribute("dateForm", dateForm);

        return "formSubmittedView";
    }
    
}

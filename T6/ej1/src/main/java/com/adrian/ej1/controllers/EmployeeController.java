package com.adrian.ej1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.adrian.ej1.model.Employee;
import com.adrian.ej1.services.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping( { "/", "/list" } )
    public String showList(@RequestParam(required = false) Integer numMsg, Model model) {
        if (numMsg != null) {
            switch (numMsg) {
                case 1 -> model.addAttribute("msg", "Employee not found");
                case 2 -> model.addAttribute("msg", "Incorrect form");
            }
        }
        model.addAttribute("employeeList", employeeService.getAll());
        return "listView";
    }

    @GetMapping("/{id}")
    public String showElement(@PathVariable long id, Model model) {
        Employee employee = employeeService.getById(id);
        if (employee == null) {
            return "redirect:/?numMsg=1";
        }
        model.addAttribute("employee", employee);
        return "listOneView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("employeeForm", new Employee());
        return "newFormView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid Employee employeeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())  {
            return "redirect:/?numMsg=2";
        }
        Employee employee = employeeService.add(employeeForm);
        if (employee == null) {
            return "redirect:/?numMsg=2";
        }
        return "redirect:/list";
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        Employee employee = employeeService.getById(id);
        if (employee == null) {
            return "redirect:/?numMsg=1";
        }
        model.addAttribute("employeeForm", employee);
        return "editFormView";
    }

    @PostMapping("/edit/{id}/submit")
    public String showEditSubmit(@PathVariable Long id, @Valid Employee employeeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/?numMsg=2";
        }
        Employee employee = employeeService.edit(employeeForm);
        if (employee == null) {
            return "redirect:/?numMsg=2";
        }
        return "redirect:/list";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        employeeService.delete(id);
        return "redirect:/list";
    }
}

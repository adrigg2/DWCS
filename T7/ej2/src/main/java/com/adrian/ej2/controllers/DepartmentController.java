package com.adrian.ej2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adrian.ej2.domain.Department;
import com.adrian.ej2.services.DepartmentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping( { "/", "/list" } )
    public String showList(@RequestParam(required = false) String msg, Model model) {
        if (msg != null) {
            model.addAttribute("msg", msg);
        }
        model.addAttribute("departmentList", departmentService.getAll());
        return "department/listView";
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("departmentForm", new Department());
        return "department/newFormView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid Department departmentForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())  {
            return "redirect:/department/?msg=Incorrect%20form";
        }
        try {
            departmentService.add(departmentForm);
            return "redirect:/department/list";
        } catch (RuntimeException e) {
            return "redirect:/department/?msg=" + e.getMessage();
        } 
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        try {
            Department department = departmentService.getById(id);
            model.addAttribute("departmentForm", department);
            return "department/editFormView";
        } catch (RuntimeException e) {
            return "redirect:/department/?msg=" + e.getMessage();
        }
    }

    @PostMapping("/edit/{id}/submit")
    public String showEditSubmit(@PathVariable Long id, @Valid Department departmentForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/department/?msg=Incorrect%20form";
        }
        try {
            departmentService.edit(departmentForm);
            return "redirect:/department/list";
        } catch (RuntimeException e) {
            return "redirect:/department/?msg=" + e.getMessage();
        } 
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        try {
            departmentService.delete(id);
            return "redirect:/department/list";
        } catch (RuntimeException e) {
            return "redirect:/department/?msg=" + e.getMessage();
        }
    }
}

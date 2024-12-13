package com.adrian.ej2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adrian.ej2.domain.Department;
import com.adrian.ej2.services.DepartmentService;

import jakarta.validation.Valid;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department/list")
    public String showList(@RequestParam(required = false) String msg, Model model) {
        model.addAttribute("msg", msg);
        model.addAttribute("departmentList", departmentService.getAll());
        return "department/listView";
    }

    @GetMapping("/department/new")
    public String showNew(@RequestParam(required = false) String msg, Model model) {
        model.addAttribute("msg", msg);

        model.addAttribute("departmentForm", new Department());
        return "department/newFormView";
    }

    @PostMapping("/department/new/submit")
    public String showNewSubmit(@Valid Department departmentForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())  {
            return "redirect:/department/new?msg=Incorrect form";
        }

        try {
            departmentService.add(departmentForm);
            return "redirect:/department/list";
        } catch (RuntimeException e) {
            return "redirect:/department/new?msg=" + e.getMessage();
        } 
    }
    
    @GetMapping("/department/edit/{id}")
    public String showEditForm(@PathVariable long id, @RequestParam(required = false) String msg, Model model) {
        model.addAttribute("msg", msg);

        try {
            Department department = departmentService.getById(id);
            model.addAttribute("departmentForm", department);
            return "department/editFormView";
        } catch (RuntimeException e) {
            return "redirect:/department/?msg=" + e.getMessage();
        }
    }

    @PostMapping("/department/edit/{id}/submit")
    public String showEditSubmit(@PathVariable Long id, @Valid Department departmentForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/department/edit/" + id + "?msg=Incorrect form";
        }
        try {
            departmentService.edit(departmentForm);
            return "redirect:/department/list";
        } catch (RuntimeException e) {
            return "redirect:/department/edit/" + id + "?msg=" + e.getMessage();
        } 
    }

    @GetMapping("/department/delete/{id}")
    public String showDelete(@PathVariable long id) {
        try {
            departmentService.delete(id);
            return "redirect:/department/list";
        } catch (RuntimeException e) {
            return "redirect:/department/list?msg=" + e.getMessage();
        }
    }
}

package com.adrian.ej2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adrian.ej2.domain.Project;
import com.adrian.ej2.services.ProjectService;

import jakarta.validation.Valid;

@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/project/list")
    public String showList(@RequestParam(required = false) String msg, Model model) {
        if (msg != null) {
            model.addAttribute("msg", msg);
        }
        model.addAttribute("projectList", projectService.getAll());
        return "project/listView";
    }

    @GetMapping("/project/new")
    public String showNew(@RequestParam(required = false) String msg, Model model) {
        if (msg != null) {
            model.addAttribute("msg", msg);
        }

        model.addAttribute("projectForm", new Project());
        return "project/newFormView";
    }

    @PostMapping("/project/new/submit")
    public String showNewSubmit(@Valid Project projectForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())  {
            return "redirect:/project/new?msg=Incorrect form";
        }

        try {
            projectService.add(projectForm);
            return "redirect:/project/list";
        } catch (RuntimeException e) {
            return "redirect:/project/new?msg=" + e.getMessage();
        } 
    }
    
    @GetMapping("/project/edit/{id}")
    public String showEditForm(@PathVariable long id, @RequestParam(required = false) String msg, Model model) {
        if (msg != null) {
            model.addAttribute("msg", msg);
        }

        try {
            Project project = projectService.getById(id);
            model.addAttribute("projectForm", project);
            return "project/editFormView";
        } catch (RuntimeException e) {
            return "redirect:/project/?msg=" + e.getMessage();
        }
    }

    @PostMapping("/project/edit/{id}/submit")
    public String showEditSubmit(@PathVariable Long id, @Valid Project projectForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/project/edit/" + id + "?msg=Incorrect form";
        }
        try {
            projectService.edit(projectForm);
            return "redirect:/project/list";
        } catch (RuntimeException e) {
            return "redirect:/project/edit/" + id + "?msg=" + e.getMessage();
        } 
    }

    @GetMapping("/project/delete/{id}")
    public String showDelete(@PathVariable long id) {
        try {
            projectService.delete(id);
            return "redirect:/project/list";
        } catch (RuntimeException e) {
            return "redirect:/project/list?msg=" + e.getMessage();
        }
    }
}

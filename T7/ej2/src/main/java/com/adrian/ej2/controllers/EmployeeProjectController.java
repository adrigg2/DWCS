package com.adrian.ej2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.adrian.ej2.domain.Employee;
import com.adrian.ej2.domain.EmployeeProject;
import com.adrian.ej2.domain.Project;
import com.adrian.ej2.services.EmployeeProjectService;
import com.adrian.ej2.services.EmployeeService;
import com.adrian.ej2.services.ProjectService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class EmployeeProjectController {
    @Autowired
    private EmployeeProjectService employeeProjectService;

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private ProjectService projectService;

    @GetMapping("/emplProj/emp/{id}")
    public String showProjectsByEmployee(@PathVariable long id, Model model) {
        try {
            Employee e = employeeService.getById(id);
            model.addAttribute("employeeProjectList", employeeProjectService.getByEmployee(e));
            model.addAttribute("employee", e);
            return "employeeProject/employeeListView";
        } catch (RuntimeException e) {
            return "redirect:/?msg=" + e.getMessage();
        }
    }

    @GetMapping("/emplProj/pro/{id}")
    public String showEmployeesByProject(@PathVariable long id, Model model) {
        try {
            Project p = projectService.getById(id);
            model.addAttribute("employeeProjectList", employeeProjectService.getByProject(p));
            model.addAttribute("project", p);
            return "employeeProject/projectListView";
        } catch (RuntimeException e) {
            return "redirect:/?msg=" + e.getMessage();
        }
    }

    @GetMapping("/emplProj/delete/{id}")
    public String showDelete(@PathVariable long id) {
        try {
            employeeProjectService.delete(employeeProjectService.getById(id));
            return "redirect:/";
        } catch (RuntimeException e) {
            return "redirect:/?msg=" + e.getMessage();
        }
    }

    @GetMapping("/emplProj/new")
    public String showNew(@RequestParam(required = false) String msg, Model model) {
        model.addAttribute("msg", msg);
        model.addAttribute("employeeProjectForm", new EmployeeProject());
        model.addAttribute("employeesList", employeeService.getAll());
        model.addAttribute("projectsList", projectService.getAll());
        return "employeeProject/newFormView";
    }

    @PostMapping("/emplProj/new/submit")
    public String newSubmit(@Valid EmployeeProject employeeProjectForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/emplProj/new?msg=Incorrect form";
        }
        employeeProjectService.add(employeeProjectForm);
        return "redirect:/";
    }
    
}

package com.adrian.ej2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.adrian.ej2.domain.Gender;
import com.adrian.ej2.model.Employee;
import com.adrian.ej2.services.EmployeeService;

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
    public String showList(@RequestParam(required = false) String msg, Model model) {
        if (msg != null) {
            model.addAttribute("msg", msg);
        }
        model.addAttribute("employeeList", employeeService.getAll());
        return "listView";
    }

    @GetMapping("/{id}")
    public String showElement(@PathVariable long id, Model model) {
        try {
            Employee employee = employeeService.getById(id);
            model.addAttribute("employee", employee);
            return "listOneView";
        } catch (RuntimeException e) {
            return "redirect:/?msg=" + e.getMessage();
        }
    }

    @GetMapping("/new")
    public String showNew(Model model) {
        model.addAttribute("employeeForm", new Employee());
        return "newFormView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid Employee employeeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())  {
            return "redirect:/?msg=Incorrect%20form";
        }
        try {
            employeeService.add(employeeForm);
            return "redirect:/list";
        } catch (RuntimeException e) {
            return "redirect:/?msg=" + e.getMessage();
        } 
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        try {
            Employee employee = employeeService.getById(id);
            model.addAttribute("employeeForm", employee);
            return "editFormView";
        } catch (RuntimeException e) {
            return "redirect:/?msg=" + e.getMessage();
        }
    }

    @PostMapping("/edit/{id}/submit")
    public String showEditSubmit(@PathVariable Long id, @Valid Employee employeeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/?msg=Incorrect%20form";
        }
        try {
            employeeService.edit(employeeForm);
            return "redirect:/list";
        } catch (RuntimeException e) {
            return "redirect:/?msg=" + e.getMessage();
        } 
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        employeeService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String getEmployeeByName(@RequestParam String name, Model model) {
        model.addAttribute("employeeList", employeeService.searchByName(name));
        return "listView";
    }

    @GetMapping("/filter")
    public String getEmployeeByGender(@RequestParam String gender, Model model) {
        if (gender.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("employeeList", employeeService.filterByGender(Gender.valueOf(gender)));
        model.addAttribute("selectedGender", gender);
        return "listView";
    }

    @GetMapping("/list1/{salary}")
    public String getList1(@PathVariable Double salary, Model model) {
        List<Employee> employees = employeeService.getEmployeesGreaterSalary(salary);
        model.addAttribute("salaryListTitle", "Employees with a salary greater than " + salary);
        model.addAttribute("salaryList", employees);
        return "listsView";
    }

    @GetMapping("/list2")
    public String getList2(Model model) {
        List<Employee> employees = employeeService.getEmployeesSalaryGreaterAverage();
        model.addAttribute("salaryListTitle", "Employees with a salary greater than average");
        model.addAttribute("salaryList", employees);
        return "listsView";
    }
}

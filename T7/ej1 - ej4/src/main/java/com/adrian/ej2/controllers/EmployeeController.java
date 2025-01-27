package com.adrian.ej2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.adrian.ej2.domain.Employee;
import com.adrian.ej2.services.DepartmentService;
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
    @Autowired
    private DepartmentService departmentService;

    @GetMapping( { "/", "/list" } )
    public String showList(@RequestParam(required = false) String msg, Model model) {
        model.addAttribute("msg", msg);
        model.addAttribute("employeeList", employeeService.getAll());
        model.addAttribute("departmentList", departmentService.getAll());
        return "employee/listView";
    }

    @GetMapping("/employee/{id}")
    public String showElement(@PathVariable long id, Model model) {
        try {
            Employee employee = employeeService.getById(id);
            model.addAttribute("employee", employee);
            return "employee/listOneView";
        } catch (RuntimeException e) {
            return "redirect:/?msg=" + e.getMessage();
        }
    }

    @GetMapping("/new")
    public String showNew(@RequestParam(required = false) String msg, Model model) {
        model.addAttribute("msg", msg);

        model.addAttribute("employeeForm", new Employee());
        model.addAttribute("departmentList", departmentService.getAll());
        return "employee/newFormView";
    }

    @PostMapping("/new/submit")
    public String showNewSubmit(@Valid Employee employeeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())  {
            return "redirect:/new?msg=Incorrect form";
        }
        try {
            employeeService.add(employeeForm);
            return "redirect:/list";
        } catch (RuntimeException e) {
            return "redirect:/new?msg=" + e.getMessage();
        } 
    }
    
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, @RequestParam(required = false) String msg, Model model) {
        model.addAttribute("msg", msg);
        
        try {
            Employee employee = employeeService.getById(id);
            model.addAttribute("employeeForm", employee);
            model.addAttribute("departmentList", departmentService.getAll());
            return "employee/editFormView";
        } catch (RuntimeException e) {
            return "redirect:/?msg=" + e.getMessage();
        }
    }

    @PostMapping("/edit/{id}/submit")
    public String showEditSubmit(@PathVariable Long id, @Valid Employee employeeForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/edit/" + id + "?msg=Incorrect form";
        }
        try {
            employeeService.edit(employeeForm);
            return "redirect:/list";
        } catch (RuntimeException e) {
            return "redirect:/edit" + id + "?msg=" + e.getMessage();
        } 
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable long id) {
        try {
            employeeService.delete(id);
            return "redirect:/list";
        } catch (RuntimeException e) {
            return "redirect:/?msg=" + e.getMessage();
        }
    }

    @GetMapping("/filter")
    public String getEmployeeByFilter(@RequestParam(required = false) String gender, @RequestParam(required = false) String name, @RequestParam(required = false) String department, Model model) {
        if (gender.isEmpty() && name.isEmpty() && department.isEmpty()) {
            return "redirect:/";
        }        

        model.addAttribute("employeeList", employeeService.filterEmployees(name, gender, department));
        model.addAttribute("departmentList", departmentService.getAll());
        return "employee/listView";
    }

    @GetMapping("/list1/{salary}")
    public String getList1(@PathVariable Double salary, Model model) {
        List<Employee> employees = employeeService.getEmployeesGreaterSalary(salary);
        model.addAttribute("salaryListTitle", "Employees with a salary greater than " + salary);
        model.addAttribute("salaryList", employees);
        return "employee/listsView";
    }

    @GetMapping("/list2")
    public String getList2(Model model) {
        List<Employee> employees = employeeService.getEmployeesSalaryGreaterAverage();
        model.addAttribute("salaryListTitle", "Employees with a salary greater than average");
        model.addAttribute("salaryList", employees);
        return "employee/listsView";
    }

    @GetMapping("/payslips/{id}")
    public String getMethodName(@PathVariable Long id, Model model) {
        try {
            Employee employee = employeeService.getById(id);
            model.addAttribute("payslips", employee.getPayslips());
            model.addAttribute("employee", employee);
            return "employee/payslipsView";
        } catch (RuntimeException e) {
            return "redirect:/?msg=" + e.getMessage();
        }
    }
    
}

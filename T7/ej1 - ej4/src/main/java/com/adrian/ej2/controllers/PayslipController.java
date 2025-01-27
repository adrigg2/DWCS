package com.adrian.ej2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adrian.ej2.domain.Payslip;
import com.adrian.ej2.services.EmployeeService;
import com.adrian.ej2.services.PayslipService;

import jakarta.validation.Valid;

@Controller
public class PayslipController {
    @Autowired
    private PayslipService payslipService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/payslip/list")
    public String showList(@RequestParam(required = false) String msg, Model model) {
        model.addAttribute("msg", msg);
        model.addAttribute("payslipList", payslipService.getAll());
        return "payslip/listView";
    }

    @GetMapping("/payslip/new")
    public String showNew(@RequestParam(required = false) String msg, Model model) {
        model.addAttribute("msg", msg);

        model.addAttribute("payslipForm", new Payslip());
        model.addAttribute("employees", employeeService.getAll());
        return "payslip/newFormView";
    }

    @PostMapping("/payslip/new/submit")
    public String showNewSubmit(@Valid Payslip payslipForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())  {
            return "redirect:/payslip/new?msg=Incorrect form";
        }

        try {
            payslipService.add(payslipForm);
            return "redirect:/payslip/list";
        } catch (RuntimeException e) {
            return "redirect:/payslip/new?msg=" + e.getMessage();
        } 
    }
    
    @GetMapping("/payslip/edit/{id}")
    public String showEditForm(@PathVariable long id, @RequestParam(required = false) String msg, Model model) {
        model.addAttribute("msg", msg);

        try {
            Payslip payslip = payslipService.getById(id);
            model.addAttribute("payslipForm", payslip);
            return "payslip/editFormView";
        } catch (RuntimeException e) {
            return "redirect:/payslip/?msg=" + e.getMessage();
        }
    }

    @PostMapping("/payslip/edit/{id}/submit")
    public String showEditSubmit(@PathVariable Long id, @Valid Payslip payslipForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/payslip/edit/" + id + "?msg=Incorrect form";
        }
        try {
            payslipService.edit(payslipForm);
            return "redirect:/payslip/list";
        } catch (RuntimeException e) {
            return "redirect:/payslip/edit/" + id + "?msg=" + e.getMessage();
        } 
    }

    @GetMapping("/payslip/delete/{id}")
    public String showDelete(@PathVariable long id) {
        try {
            payslipService.delete(id);
            return "redirect:/payslip/list";
        } catch (RuntimeException e) {
            return "redirect:/payslip/list?msg=" + e.getMessage();
        }
    }

    @GetMapping("/payslip/load/new")
    public String getNew() {
        payslipService.loadNewPayslips();
        return "redirect:/payslip/list";
    }

    @GetMapping("/payslip/load/all")
    public String getAll() {
        payslipService.loadOldPayslips();
        return "redirect:/payslip/list";
    }
    
}

package com.adrian.ej2.services;

import java.util.List;

import com.adrian.ej2.domain.Payslip;

public interface PayslipService {
    Payslip add(Payslip department);
    List<Payslip> getAll();
    Payslip getById(long id);
    Payslip edit(Payslip department);
    void delete(long id);
    void loadNewPayslips();
    void loadOldPayslips();
}

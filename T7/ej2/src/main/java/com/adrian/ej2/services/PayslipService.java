package com.adrian.ej2.services;

import java.util.List;

import com.adrian.ej2.domain.Payslip;

public interface PayslipService {
    Payslip add(Payslip department);
    List<Payslip> getAll();
    Payslip getById(long id) throws RuntimeException;
    Payslip edit(Payslip department) throws RuntimeException;
    void delete(long id) throws RuntimeException;
    void loadNewPayslips() throws RuntimeException;
    void loadOldPayslips() throws RuntimeException;
}

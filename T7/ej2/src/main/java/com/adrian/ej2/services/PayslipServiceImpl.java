package com.adrian.ej2.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.ej2.domain.Employee;
import com.adrian.ej2.domain.Payslip;
import com.adrian.ej2.repositories.EmployeeRepository;
import com.adrian.ej2.repositories.PayslipRepository;

@Service
public class PayslipServiceImpl implements PayslipService {
    @Autowired
    private PayslipRepository repository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Payslip add(Payslip department) {
        return repository.save(department);
    }

    @Override
    public List<Payslip> getAll() {
        return repository.findAll();
    }

    @Override
    public Payslip getById(long id) throws RuntimeException {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("There is no payslip with that id"));
    }

    @Override
    public Payslip edit(Payslip department) throws RuntimeException {
        getById(department.getId()); // Check if department exists
        return repository.save(department);
    }

    @Override
    public void delete(long id) throws RuntimeException {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public void loadNewPayslips() throws RuntimeException {
        try {
            File[] newPayslips = new File("payslips").listFiles((_, file) -> {
                return file.endsWith(".csv");
            });

            if (newPayslips == null) {
                return;
            }

            for (File payslip : newPayslips) {
                List<String> data = Files.readAllLines(payslip.toPath());
                for (String line : data) {
                    String[] payslipData = line.split(",");
                    LocalDate date = LocalDate.parse(payslipData[0]);
                    Double grossSalary = Double.parseDouble(payslipData[1]);
                    Double tax = Double.parseDouble(payslipData[2]);
                    Double netSalary = Double.parseDouble(payslipData[3]);
                    Employee employee = employeeRepository.findById(Long.parseLong(payslipData[4])).orElseThrow(() -> new RuntimeException("Incorrect employee id"));
                    repository.save(new Payslip(null, date, grossSalary, tax, netSalary, employee));
                }
                Files.move(payslip.toPath(), Path.of("payslips/legacy/" + payslip.getName()));
            }
        } catch (IOException e) {
            throw new RuntimeException("There has been an error loading the payslips" + e.getMessage());
        }
    }

    @Override
    public void loadOldPayslips() throws RuntimeException {
        try {
            File[] newPayslips = new File("payslips/legacy").listFiles((_, file) -> {
                return file.endsWith(".csv");
            });

            if (newPayslips == null) {
                return;
            }

            repository.deleteAll();
            
            for (File payslip : newPayslips) {
                List<String> data = Files.readAllLines(payslip.toPath());
                for (String line : data) {
                    String[] payslipData = line.split(",");
                    LocalDate date = LocalDate.parse(payslipData[0]);
                    Double grossSalary = Double.parseDouble(payslipData[1]);
                    Double tax = Double.parseDouble(payslipData[2]);
                    Double netSalary = Double.parseDouble(payslipData[3]);
                    Employee employee = employeeRepository.findById(Long.parseLong(payslipData[4])).orElseThrow(() -> new RuntimeException("Incorrect employee id"));
                    repository.save(new Payslip(null, date, grossSalary, tax, netSalary, employee));
                }
            }

            loadNewPayslips();
        } catch (IOException e) {
            throw new RuntimeException("There has been an error loading the payslips");
        }
    }
}

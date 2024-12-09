package com.adrian.ej2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.ej2.domain.Payslip;
import com.adrian.ej2.repositories.PayslipRepository;

@Service
public class PayslipServiceImpl implements PayslipService {
    @Autowired
    private PayslipRepository repository;

    @Override
    public Payslip add(Payslip department) {
        return repository.save(department);
    }

    @Override
    public List<Payslip> getAll() {
        return repository.findAll();
    }

    @Override
    public Payslip getById(long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("There is no payslip with that id"));
    }

    @Override
    public Payslip edit(Payslip department) {
        getById(department.getId()); // Check if department exists
        return repository.save(department);
    }

    @Override
    public void delete(long id) {
        getById(id);
        repository.deleteById(id);
    }
}

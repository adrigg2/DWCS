package com.adrian.ej2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrian.ej2.domain.Payslip;

public interface PayslipRepository extends JpaRepository<Payslip, Long> {

}

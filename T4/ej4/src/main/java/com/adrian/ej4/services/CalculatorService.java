package com.adrian.ej4.services;

import com.adrian.ej4.OperationState;

public interface CalculatorService {
    Integer getFirstOperand();
    Integer getSecondOperand();
    OperationState getOperationState();
    Integer getResult();
    void setOperand(Integer number);
    void changeOperand(boolean add);
    void add();
    void clear();
}

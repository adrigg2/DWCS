package com.adrian.ej4.services;

import org.springframework.stereotype.Service;

import com.adrian.ej4.OperationState;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    private Integer firstOperand = 0;
    private Integer secondOperand = 0;
    private Integer substract = 1;
    private Integer result;
    private OperationState operationState = OperationState.FIRST_OPERAND;

    @Override
    public void setOperand(Integer number) {
        if (operationState == OperationState.FIRST_OPERAND) {
            firstOperand = firstOperand * 10 + number;
        }
        else if (operationState == OperationState.SECOND_OPERAND) {
            secondOperand = secondOperand * 10 + number;
        }
    }

    @Override
    public void add() {
        operationState = OperationState.RESULT;
        result = firstOperand + secondOperand * substract;
    }

    @Override
    public void clear() {
        firstOperand = 0;
        secondOperand = 0;
        result = null;
        operationState = OperationState.FIRST_OPERAND;
    }

    @Override
    public void changeOperand(boolean add) {
        if (operationState == OperationState.RESULT) return;

        if (!add) substract = -1;
        else substract = 1;
        operationState = OperationState.SECOND_OPERAND;
    }

    @Override
    public Integer getFirstOperand() {
        return firstOperand;
    }

    @Override
    public Integer getSecondOperand() {
        return secondOperand;
    }

    @Override
    public OperationState getOperationState() {
        return operationState;
    }

    @Override
    public Integer getResult() {
        return result;
    }
}

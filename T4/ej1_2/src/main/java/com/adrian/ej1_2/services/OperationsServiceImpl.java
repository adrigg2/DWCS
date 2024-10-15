package com.adrian.ej1_2.services;

import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class OperationsServiceImpl implements OperationService {

    @Override
    public boolean isPrime(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number should be greater than 0");
        }

        if (number == 2 || number == 3 || number == 5) {
            return true;
        }

        if (number == 1 || number % 2 == 0 || number % 3 == 0 || number % 5 == 0) {
            return false;
        }

        for (int i = 7; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Float calculateHypotenuse(Float a, Float b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Triangle sides should be greater than 0");
        }
        
        return (float)Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    @Override
    public TreeSet<Integer> calculateDivisors(Integer number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number should be greater than 0");
        }

        TreeSet<Integer> divisors = new TreeSet<>();
        for (int i = 1; i < number / 2; i++) {
            if (number % i == 0) {
                divisors.add(i);
                divisors.add(number / i);
            }
        }
        return divisors;
    }
    
}

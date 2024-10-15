package com.adrian.ej1_2.services;

import java.util.TreeSet;

public interface OperationService {
    boolean isPrime(Integer number);
    Float calculateHypotenuse(Float a, Float b);
    TreeSet<Integer> calculateDivisors(Integer number);
}

package com.adrian.ej3.services;

import java.util.Set;

public interface NumbersService {
    Set<Integer> getList();
    void generateNumber();
    void removeNumber(Integer id);
}

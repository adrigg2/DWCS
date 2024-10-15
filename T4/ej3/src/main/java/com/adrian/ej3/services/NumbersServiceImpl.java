package com.adrian.ej3.services;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class NumbersServiceImpl implements NumbersService {
    private Random random = new Random();
    private Set<Integer> list = new LinkedHashSet<>(); 

    public Set<Integer> getList() {
        return list;
    }

    @Override
    public void generateNumber() {
        boolean added;
        do {
            added = list.add(random.nextInt(100) + 1);
        } while (!added);
    }

    @Override
    public void removeNumber(Integer id) {
        list.remove(id);
    }    
}

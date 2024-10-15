package com.adrian.ej5.services;

import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService {

    @Override
    public Double calcalutaHypothenuse(String cat1, String cat2) throws RuntimeException {
        Double cath1, cath2;
        try {
            cath1 = Double.parseDouble(cat1);
            cath2 = Double.parseDouble(cat2);
        } catch (Exception e) {
            throw new RuntimeException("Algún cateto no numérico");
        }

        if (cath1 <= 0 || cath2 <= 0) {
            throw new RuntimeException("Algún cateto menor que 0");
        }
        else if (cath1 > 1000 || cath2 > 1000) {
            throw new RuntimeException("Algún cateto mayor que 1000");
        }

        return Math.hypot(cath1, cath2);
    }
    
}

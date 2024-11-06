package com.adrian;

import java.util.Comparator;

// Clase para comparar los estudiantes por año de nacimiento
public class ComparadorEdadEstudiante implements Comparator<Estudiante> {
    @Override
    public int compare(Estudiante o1, Estudiante o2) {
        if (o1.getAnoNacimiento() > o2.getAnoNacimiento()) {
            return 1;
        } else if (o1.getAnoNacimiento() < o2.getAnoNacimiento()) {
            return -1;
        } else {
            return 0;
        }
    }
}

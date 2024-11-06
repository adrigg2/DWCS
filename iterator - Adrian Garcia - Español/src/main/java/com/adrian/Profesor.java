package com.adrian;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.Iterator;

// Clase para representar un profesor. Se puede iterar sobre él para comprobrar sus estudiantes uno a uno
public class Profesor extends Persona implements Iterable<Estudiante> {
    private TreeSet<Estudiante> estudiantes;

    public Profesor(int id, int anoNacimiento, String nombre) {
        super(id, anoNacimiento, nombre);
        estudiantes = new TreeSet<>(new ComparadorNotaEstudiante());
    }

    public boolean anadirEstudiante(Estudiante estudiante) {
        return estudiantes.add(estudiante);
    }

    // Iterador con los estudiantes
    @Override
    public Iterator<Estudiante> iterator() {
        return new IteradorEstudiante(estudiantes);
    }

    // Clase para comparar estudiantes por nota
    private class ComparadorNotaEstudiante implements Comparator<Estudiante> {
        @Override
        public int compare(Estudiante o1, Estudiante o2) {
            if (o1.getNota() > o2.getNota()) {
                return 1;
            } else if (o1.getNota() < o2.getNota()) {
                return -1;
            } else {
                return 0;
            }
        }
    }    
}

package com.adrian;

import java.util.TreeSet;

public class App 
{
    public static void main( String[] args )
    {
        // Inicializa al Profesor y le da algunos estudiantes
        Profesor profesor = new Profesor(0, 1970, "Profe");
        profesor.anadirEstudiante(new Estudiante(1, 2003, "estudiante1", 5));
        profesor.anadirEstudiante(new Estudiante(2, 2005, "estudiante2", 10));
        profesor.anadirEstudiante(new Estudiante(3, 2004, "estudiante3", 2));
        profesor.anadirEstudiante(new Estudiante(4, 1995, "estudiante4", 6));
        profesor.anadirEstudiante(new Estudiante(5, 1992, "estudiante5", 1));
        profesor.anadirEstudiante(new Estudiante(6, 2000, "estudiante6", 4));
        profesor.anadirEstudiante(new Estudiante(7, 1999, "estudiante7", 3));
        profesor.anadirEstudiante(new Estudiante(8, 2005, "estudiante8", 8));
        profesor.anadirEstudiante(new Estudiante(9, 2003, "estudiante9", 7));
        profesor.anadirEstudiante(new Estudiante(10, 2000, "estudiante10", 5));
        
        // Comprueba cada estudiante en el profesor e imprime los que aprueban, en orden descendiente de nota
        System.out.println("\nEstudiantes que aprueban:");
        profesor.forEach((estudiante) -> {
            if (estudiante.getNota() >= 5) {
                System.out.println(estudiante);
            }
        });

        IteradorEstudiante iterador = (IteradorEstudiante)profesor.iterator();
        iterador.reverseIndex();

        // Comprueba cada estudiante en el profesor y los imprime en orden inverso de nota
        System.out.println("\nEstudiantes por nota en orden inverso:");
        TreeSet<Estudiante> estudiantesPorEdad = new TreeSet<>(new ComparadorEdadEstudiante());
        while (iterador.hasPrevious()) {
            Estudiante estudiante = iterador.previous();
            System.out.println(estudiante);
            estudiantesPorEdad.add(estudiante);
        }

        // Comprueba cada estudiante en el profesor y los imprime por orden ascendiente de año de nacimiento
        System.out.println("\nEstudiantes por edad:");
        estudiantesPorEdad.forEach((estudiante) -> {
            System.out.println(estudiante);
        });
    }
}

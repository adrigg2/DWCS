package com.adrian;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

// Clase que crea un iterador para los estudiantes. Provee métodos para recorrer la colección tanto en el orden normal como en el inverso
public class IteradorEstudiante implements Iterator<Estudiante> {
    private int indice = 0;
    private ArrayList<Estudiante> iterador;

    public IteradorEstudiante(Collection<Estudiante> estudiantes) {
        iterador = new ArrayList<>(estudiantes);
    }

    // Comprueba que haya más elementos en el iterador
    @Override
    public boolean hasNext() {
        return indice < iterador.size();
    }

    // Devuelve el siguiente elemento del iterador
    @Override
    public Estudiante next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay más elementos en la lista");
        }
        // Devuelve el siguiente elemento y, después, incrementa el índice
        return iterador.get(indice++);
    }

    // Comprueba que haya más elementos en el iterador en orden inverso
    public boolean hasPrevious() {
        return indice > 0;
    }

    // Devuelve el elemento anterior del iterador
    public Estudiante previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException("There are no more elements in the list");
        }
        // Devuelve el anterior elemento y, después, disminuye el índice
        return iterador.get(indice--);
    }

    // Establece el índice del iterador al final (si no es mayor que la mitad de la colección)/inicio (si es mayor que la mitad de la colección) 
    // de la colección para permitir leer la colleción en orden inverso/normal
    public void reverseIndex() {
        indice = indice < (iterador.size() / 2) ? iterador.size() - 1 : 0;
    }
}

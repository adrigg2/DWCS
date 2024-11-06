package com.adrian;

// Clase para representar a un estudiante
public class Estudiante extends Persona {
    private int nota;

    public Estudiante(int id, int anoNacimiento, String nombre, int nota) {
        super(id, anoNacimiento, nombre);
        this.nota = nota;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return super.toString() + ", nota: " + nota;
    }
}

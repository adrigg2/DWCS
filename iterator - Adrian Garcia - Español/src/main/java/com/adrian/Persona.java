package com.adrian;

// Clase base para una persona genérica
public class Persona {
    private int id;
    private int anoNacimiento;
    private String nombre;

    public Persona(int id, int anoNacimiento, String nombre) {
        this.id = id;
        this.anoNacimiento = anoNacimiento;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public int getAnoNacimiento() {
        return anoNacimiento;
    }    

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + ", año de nacimiento: " + anoNacimiento;
    }
}

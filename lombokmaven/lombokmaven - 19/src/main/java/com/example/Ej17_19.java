package com.example;

import lombok.*;

@Getter
@ToString
@Builder(builderMethodName = "interno")
class Usuario {

    @NonNull
    private String email;
    private String nombre;

    // Sobrecargo el método builder para que reciba el parámetro nombre
    // El método devuelve un nuevo tipo UsuarioBuilder, formado por el método
    // interno() y el método nombre().
    // El tipo UsuarioBuilder es un tipo interno de Usuario, por lo que no se puede
    // acceder desde fuera de Usuario y debe ser creado por el método interno().
    // La convención para nombrar el tipo devuelto es el nombre de la clase original
    // seguido de Builder.
    public static UsuarioBuilder builder(String nombre) {
        return interno().nombre(nombre);
    }
}

public class Ej17_19 {
    public static void main(String[] args) {
        // Paso el parámetro nombre al builder
        Usuario u = Usuario.builder("Ana")
                .email("ana@mail.gal")
                .build();
        System.out.println(u);
    }
}
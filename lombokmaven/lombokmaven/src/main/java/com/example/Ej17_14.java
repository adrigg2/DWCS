package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

@Getter
@AllArgsConstructor
@ToString
class Usuario {
    private final String nombre;
    private final String email;
    @With
    private final boolean autenticado;
}

public class Ej17_14 {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Ana", "ana@mail.com", false);
        System.out.println(usuario);
        Usuario uAuten = usuario.withAutenticado(true);
        System.out.println(uAuten);
        long a = 0x0123456789ABCDEFL;
        long b = 0b1001010101010101010101010100000000000011010100000000111111101010L;
    }
} // imprescidible constructor por ser clase inmutable

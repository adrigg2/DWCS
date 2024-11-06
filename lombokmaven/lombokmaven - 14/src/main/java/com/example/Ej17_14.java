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
        Usuario uAuten = usuario.withAutenticado(true);
        System.out.println(usuario);
        System.out.println(uAuten);
        System.out.println(usuario == uAuten);
        Usuario usu2 = usuario.withAutenticado(false);
        System.out.println(usu2 == usuario);
        
        long a = 0x0123456789ABCDEFL;
        long b = 0b1111111111111111111111111111111111111111111111111111111111111111L;
        Clase clase = new Clase(1);

        System.out.println(a);
        System.out.println(b);
        System.out.println(clase.getId());
    }
} // imprescidible constructor por ser clase inmutable

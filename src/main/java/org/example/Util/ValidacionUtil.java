package org.example.Util;

public class ValidacionUtil {//se crea la clase validacioneutil respetando Single responsability, verifica las reglas

    public static boolean textoVacio(String texto){// evita los campos vacios
        return texto == null || texto.trim().isEmpty();
    }

    public static boolean correoValido(String correo){// filtro para recibir un formato valido de correo electronico
        return correo.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
      //la informacion para la realizacion de esto fue de foros como reddit,mailtrap incluso la ia resolvio un tema de logica interna entre el uso de las reglas en el main

}

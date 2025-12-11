package cl.salmontt.util;

import javax.swing.*;

public class ValidaFormatoRut {

    /**
     * Metodo que valida el formato del RUT ingresado es correcto
     * @param formatoRut es la cadena de texto a validar (ingreso del RUT)
     */
    public static void validar(String formatoRut) throws ValidaRutException {
        String formato = "^[0-9]+-[0-9Kk]$";
        if(!formatoRut.matches(formato)){
            throw new ValidaRutException("Por favor revisa el formato e intenta nuevamente. Ejemplo: 87654321-9 o K");
        }
    }


}

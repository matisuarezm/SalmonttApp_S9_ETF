package cl.salmontt.util;

/**
 * Clase validadora con una excepcion específica para la validacion del RUT, extendida de {@link Exception}
 *
 * @author msuarez
 * @version 1.0
 */

public class ValidaRutException extends Exception{

    /**Metodo constructor para arrojar el mensaje de la excepcion llamando a la clase padre con super() */
    public ValidaRutException(String mensaje){
        super(mensaje);
    }
}

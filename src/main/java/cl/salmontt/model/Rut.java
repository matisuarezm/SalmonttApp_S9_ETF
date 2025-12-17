package cl.salmontt.model;

import cl.salmontt.util.ValidaFormatoRut;
import cl.salmontt.util.ValidaRutException;


/**
 * Clase específica para el RUT de un cliente, en donde establecemos el formato de ingreso y un constructor
 * que verifíca si se cumple el formato correspondiente. Esta clase es parte por medio de la composicion de la clase {@link Persona}
 *
 * @author msuarez
 * @version 1.0
 */

public class Rut {

    //Atributos
    private String textoRut;

    /**
     * Constructor que recibe un texto como parametro y se valida que cumpla el formato esperado.
     * @param textoRut Texto del rut a validar
     * @throws ValidaRutException si el RUT no cumple con el formato indicado
     */
    public Rut(String textoRut) throws ValidaRutException {
        ValidaFormatoRut.validar(textoRut);
        this.textoRut = textoRut;
    }

    /** Retorna el RUT en formato texto */
    public String getTextoRut(){
        return textoRut;
    }

    /** Establece el rut de una persona y lo valida */
    public void setTextoRut(String nuevoRut) throws ValidaRutException {
        ValidaFormatoRut.validar(nuevoRut);
        this.textoRut = nuevoRut;
    }

    /** Forma en que se mostrara el RUT al imprimirlo por consola */
    @Override
    public String toString(){
        return String.format("%-10s %s\n","RUT:", textoRut);
        //return "RUT: " + textoRut + '\n';
    }
}

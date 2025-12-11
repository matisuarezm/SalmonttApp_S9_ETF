package cl.salmontt.model;

import cl.salmontt.util.ValidaRutException;

/**
 * Clase abstracta que funciona como base para ser heredada, está compuesta por las subclases {@link Rut} y {@link Direccion}
 *
 * @author msuarez
 * @version 1.0
 */

public abstract class Entidad {

    //Atrubutos privados de la clase
    private String nombre;
    private Rut rut;
    private Direccion direccion;
    private String telefono;
    private String email;

    /** Constructo vacio para crear una persona por medio de la herencia*/
    public Entidad(){}

    /**
     * Constructor que inicializa una persona con todos sus datos personales y de contacto
     *
     * @param nombre es el nombre de la persona en formato String.
     * @param textoRUT es la creacion del objeto de rut en formato String con su respectiva excepcion.
     * @param direccion es un objeto direccion con todos los datos del domicilio.
     * @param telefono es el telefono asociado al cliente.
     * @throws ValidaRutException si el textoRut no cumple con el formato.
     */
    public Entidad(String nombre, String textoRUT, Direccion direccion, String telefono, String email) throws ValidaRutException {
        this.nombre = nombre;
        this.rut = new Rut(textoRUT);
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    /**
     * Sobre carga de metodo constructor que permite crear una persona con sus datos personales y los atributos individuales de la direccion
     * @param nombre es el nombre de la persona en formato String.
     * @param textoRUT el RUT de la persona que será validado al crear el objeto RUT
     * @param direccion el nombre de la calle del domicilio * @param comuna la comuna donde se encuentra el domicilio
     * @param region region geográfica del domicilio
     * @param telefono telefono de contacto de la persona
     * @throws ValidaRutException si el textoRut no cumple el formato esperado
     */
    public Entidad(String nombre, String textoRUT,
                   String direccion, String comuna, String region,
                   String telefono, String email) throws ValidaRutException {
        this.nombre = nombre;
        this.rut = new Rut(textoRUT);
        this.direccion = new Direccion(direccion, comuna,region);
        this.telefono = telefono;
        this.email = email;
    }

    /** Retorna el nombre de una Persona */
    public String getNombre(){
        return nombre;
    }

    /** Retorna el rut de una Persona */
    public Rut getRut(){
        return rut;
    }

    /** Retorna la direccion de una Persona */
    public Direccion getDireccion(){
        return direccion;
    }

    /** Retorna el telefono de una Persona */
    public String getTelefono(){
        return telefono;
    }

    public String getEmail(){ return email; }

    /** Establece un nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Establece el RUT */
    public void setRut(Rut rut){
        this.rut = rut;
    }

    /** Sobre carga de método set para establecer un RUT sin crear el objeto antes */
    public void setRut(String rut) throws ValidaRutException {
        this.rut = new Rut(rut);
    }

    /** Establece una direccion */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /** Sobre carga de método set para establecer una direccion sin crear el objeto antes */
    public void setDireccion(String calle, String comuna, String region){
        this.direccion = new Direccion(calle, comuna, region);
    }

    /** Establece un telefono */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email){this.email = email; }

    /**
     * Es una representacion textual de una persona con todos sus atributos como nombre, apellido, telefono y direccion
     * @return una cadena de texto con los atributos del cliente formateados
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //sb.append("Nombre:    ").append(nombre).append(" ").append(apellido).append("\n");
        sb.append(String.format("%-10s %s\n", "Nombre o Razón:", nombre));
        sb.append(rut);
        if (telefono != null && !telefono.isEmpty()) {
            //sb.append("Teléfono:  ").append(telefono).append("\n");
            sb.append(String.format("%-10s %s\n", "Teléfono:", telefono));
        }
        if (direccion != null && !direccion.toString().isEmpty()){
            sb.append(direccion).append("\n");
        }
        if (email != null && !email.isEmpty()) {
            sb.append(String.format("%-10s %s\n","Email:",email));
        }

        return sb.toString();
    }
}


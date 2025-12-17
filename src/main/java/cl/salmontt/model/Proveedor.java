package cl.salmontt.model;

import cl.salmontt.util.ValidaRutException;

/**
 * Representa a un proveedor de la empresa, extendiendo los datos personales definidos en {@link Persona}.
 *
 * @author msuarez
 * @version 1.0
 */
public class Proveedor extends Persona{

    private String giro;

    /**
     * Constructor vacio para facilitar la creacion de la instancia sin inicializar atributos.
     */
    public Proveedor(){}

    /**
     * Crea un proveedor utilizando una direccion compuesta
     * @param nombre Nombre del proveedor
     * @param rut RUT del proveedor en texto
     * @param direccion Objeto {@link Direccion} con los datos del domicilio
     * @param telefono telefono de contacto
     * @param email correo electronico de contacto
     * @param giro giro comercial del proveedor
     * @throws ValidaRutException si el RUT no cumple con el formato o reglas de validación
     */
    public Proveedor(String nombre, String rut, Direccion direccion, String telefono, String email
            , String giro) throws ValidaRutException {
        super(nombre, rut, direccion, telefono, email);
        this.giro = giro;
    }

    /**
     * Crea un proveedor utilizando los datos de direccion desglosados (direccion, comuna y region)
     * junto a la información de contacto y giro.
     * @param nombre Nombre del proveedor
     * @param rut RUT del proveedor en formato texto
     * @param direccion Direccion en formato texto
     * @param comuna comuna del domicilio
     * @param region region del domicilio
     * @param telefono telefono de contacto
     * @param email correo electronco de contacto
     * @param giro giro comercial del proveedor
     * @throws ValidaRutException si el RUT no cumple el formato o las reglas de validación
     */
    public Proveedor(String nombre, String rut, String direccion, String comuna, String region, String telefono, String email
            , String giro) throws ValidaRutException {
        super(nombre, rut, direccion, comuna,region, telefono, email);
        this.giro = giro;
    }

    /**
     * Obtiene el giro comercial del proveedor
     * @return giro del proveedor
     */
    public String getGiro() {
        return giro;
    }

    /**
     * Establece el giro comercial del proveedor
     * @param giro giro comercial nuevo
     */
    public void setGiro(String giro) {
        this.giro = giro;
    }

    /**
     * {@inheritDoc}
     * En este caso, el resumen incluye nombre, RUT, giro y telefono del proveedor
     * @return cadena con un resumen compacto del proveedor
     */
    @Override
    public String mostrarResumen() {
        return "[Proveedor] " + getNombre() +
                " | Giro: " + getGiro() +
                " | Rut: " + getRut().getTextoRut() +
                " | Teléfono: " + getTelefono();
    }

    /**
     * Devuelve una representacion textual detallada del proveedor
     * @return cadena de texto con información del proveedor
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("%-10s %s\n", "Giro:", giro));

        return sb.toString();
    }
}

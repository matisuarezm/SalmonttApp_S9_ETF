package cl.salmontt.model;

import cl.salmontt.util.ValidaRutException;

/**
 * Representa un cliente dentro del modelo de dominio, extiende de {@link Persona} y agrega información comercial.
 *
 * @author msuarez
 * @version 1.0
 */
public class Cliente extends Persona{

    /**
     * Codigo interno que identifica de forma unica al cliente
     */

    private String codigoCliente;
    /**
     * Tipo de cliente, hace referencia a la categoria del cliente (premium, gold, elite, platinium).
     */

    private String tipoCliente;

    /**
     * Tarjeta asociada al cliente para operaciones de pago
     */
    private Tarjeta tarjeta;

    /**
     * Crea un cliente con la informacion minima
     * @param nombre Nombre del CLiente
     * @param rut RUT del cliente en formato texto
     * @param codigoCliente código del cliente
     * @param tipoCliente tipo de cliente
     * @param tarjeta tarjeta asociada al cliente
     * @throws ValidaRutException si el RUT no cumple con el formato o las reglas definidas.
     */
    public Cliente(String nombre, String rut, String codigoCliente, String tipoCliente, Tarjeta tarjeta ) throws ValidaRutException {
        super(nombre, rut, null, null, null);
        this.codigoCliente = codigoCliente;
        this.tipoCliente = tipoCliente;
        this.tarjeta = tarjeta;
    }

    /**
     * Crea un cliente con direccion compuestas y datos de contacto además de los atributos propios.
     * @param nombre Nombre de cliente
     * @param rut RUT del cliente en formato texto
     * @param direccion direccion del cliente como objeto {@link Direccion}
     * @param telefono telefono de contacto
     * @param mail correo electronico de contacto
     * @param codigoCliente codigo interno del cliente
     * @param tipoCliente tipo de cliente
     * @param tarjeta tarjeta asociada
     * @throws ValidaRutException si le RUT no cumple con el formato o las reglas definidas
     */
    public Cliente(String nombre, String rut, Direccion direccion, String telefono, String mail,
                   String codigoCliente, String tipoCliente, Tarjeta tarjeta) throws ValidaRutException {
        super(nombre, rut, direccion, telefono, mail);
        this.codigoCliente = codigoCliente;
        this.tipoCliente = tipoCliente;
        this.tarjeta = tarjeta;
    }

    /**
     * Crea un cliente con la direccion desglosada en un texto
     * @param nombre Nombre del cliente
     * @param rut RUT del cliente en formato texto
     * @param direccion direccion del cliente en formato texto
     * @param comuna comuna asociada a direccion del cliente
     * @param region region asociada a direccion del cliente
     * @param telefono telefono de contacto
     * @param mail correo electronico del cliente
     * @param codigoCliente codigo interno del cliente
     * @param tipoCliente tipo de cliente
     * @param tarjeta tarjeta asociada al cliente
     * @throws ValidaRutException si le RUT no cumple con el formato o las reglas definidas
     */
    public Cliente(String nombre, String rut, String direccion, String comuna, String region, String telefono, String mail,
                   String codigoCliente, String tipoCliente, Tarjeta tarjeta) throws ValidaRutException {
        super(nombre, rut, direccion, comuna, region, telefono, mail);
        this.codigoCliente = codigoCliente;
        this.tipoCliente = tipoCliente;
        this.tarjeta = tarjeta;
    }

    /**
     * Obtiene el codigo interno del cliente
     * @return codigo de cliente
     */
    public String getCodigoCliente(){
        return codigoCliente;
    }

    /**
     * Obtiene el tipo de cliente
     * @return tipo de cliente
     */
    public String getTipoCliente(){
        return tipoCliente;
    }

    /**
     * Obtiene la tarjeta asociada al cliente
     * @return objeto {@link Tarjeta} del cliente
     */
     public Tarjeta getTarjeta(){
        return tarjeta;
     }

    /**
     * Simula el registro de un nuevo cliente a la lista de Registrable
     */
    @Override
    public void registrar() {
        System.out.println("Registrando Cliente: " + getNombre());
    }

    /**
     * {@inheritDoc}
     * En este caso, el resumen incluye codigo, nombre, tipo de cliente y banco de la tarjeta asociada
     * @return cadena con un resumen compacto de la información del cliente
     */
    @Override
    public String mostrarResumen() {
        return "[Cliente] " + getCodigoCliente() +
                " | Nombre: " + getNombre() +
                " | Tipo: " + getTipoCliente() +
                " | Banco: " + getTarjeta().getBanco();

    }

    /**
     * Devuelve una represntacin detallada del cliente incluyendo todos sus atributos y los heredados de {@link Persona}
     * además, información de la tarjeta asociada
     * @return descripcion en texto del cliente.
     */
     @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("%-10s %s\n","Cod. Cliente:",codigoCliente));
        sb.append(String.format("%-10s %s\n","Tipo Cliente:",tipoCliente));
        sb.append(tarjeta);
        return sb.toString();
     }
}

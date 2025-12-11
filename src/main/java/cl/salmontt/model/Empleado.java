package cl.salmontt.model;

import cl.salmontt.util.ValidaRutException;
import cl.salmontt.util.ValidaSueldoEmpleado;

/**
 * Clase que representa a un empleado de la empresa salmontt, extendiendo los datos de personales de la calse {@link Entidad}.
 * incluye información laboral como fecha de ingreso, cargo, departamento, mail y sueldo
 *
 * @author msuarez
 * @version 1.0
 */

public class Empleado extends Entidad implements Registrable{

    private String fechaIngreso;
    private String cargo;
    private String departamento;
    private double sueldo;

    /** Constructor vacio para facilitar la herencia */
    public Empleado(){}

    /**
     * Constructor con parametros que inicializa solo los datos laborales del empleado
     *
     * @param fechaIngreso Fecha de ingreso en formato String
     * @param cargo Cargo laboral
     * @param departamento Departamento o area del empleado
     * @param sueldo Salario mensual. Debe ser mayor a 0
     * @throws IllegalArgumentException si el sueldo es negativo.
     */
    public Empleado(String fechaIngreso,String cargo,String departamento, double sueldo){ //Datos Empleado
        ValidaSueldoEmpleado.validar(sueldo);
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
        this.departamento = departamento;
        this.sueldo = sueldo;
    }

    /**
     * Constructor que inicializa todos los parametros Laborales y Personales de un empleado
     *
     * @param nombre Nombre del empleado
     * @param textoRut RUT en formato String
     * @param direccion objeto Direccion con los datos del domicilio
     * @param telefono Telefono de contacto
     * @param fechaIngreso Fecha de ingreso
     * @param cargo Cargo laboral
     * @param departamento Departamento
     * @param email Correo electronico corporativo
     * @param sueldo Salario mensual, mayor que 0
     * @throws ValidaRutException Si el rut no cumple el formato esperado
     * @throws IllegalArgumentException si sueldo es menor que 0
     */
    public Empleado(String nombre, String textoRut, Direccion direccion, String telefono, String email,
                    String fechaIngreso,String cargo,String departamento, double sueldo) throws ValidaRutException {
        super(nombre, textoRut, direccion, telefono,email);
        ValidaSueldoEmpleado.validar(sueldo);
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
        this.departamento = departamento;
        this.sueldo = sueldo;
    }

    /**
     * Constructor complementario que permite inicializar el empleado con los atributos de direccion individualmente.
     *
     * @param nombre Nombre del empleado
     * @param textoRut RUT en formato String
     * @param calle Calle del domicilio
     * @param comuna Comuna de domicilio
     * @param region Region geografica
     * @param telefono Telefono de contacto
     * @param fechaIngreso Fecha de ingreso
     * @param cargo Cargo laboral
     * @param departamento Departamento
     * @param email Correo electronico corporativo
     * @param sueldo Salario mensual, mayor que 0
     * @throws ValidaRutException Si el rut no cumple el formato esperado
     * @throws IllegalArgumentException si sueldo es menor que 0
     */
    public Empleado(String nombre, String textoRut, String calle, String comuna, String region,
                    String telefono, String email, String fechaIngreso,String cargo,String departamento, double sueldo) throws ValidaRutException {
        super(nombre, textoRut, calle, comuna, region, telefono, email);
        ValidaSueldoEmpleado.validar(sueldo);
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
        this.departamento = departamento;
        this.sueldo = sueldo;
    }

    /** @return Fecha de ingreso del empleado*/
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    /** @return Cargo laboral del empleado*/
    public String getCargo() {
        return cargo;
    }

    /** @return Departamento del empleado*/
    public String getDepartamento() {
        return departamento;
    }

    /** @return Sueldo mensual del empleado*/
    public double getSueldo() {
        return sueldo;
    }

    /** Establece la fecha de ingreso
     * @param fechaIngreso Fecha en formato String
     */
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Establece el cargo laboral del empleado
     * @param cargo Cargo laboral
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Establece el departamento del empleado
     * @param departamento Departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Establece el sueldo del empleado, validando que sea mayor a 0
     * @param sueldo Sueldo mensual
     * @throws IllegalArgumentException si el sueldo es menor que 0
     */
    public void setSueldo(double sueldo) {
        ValidaSueldoEmpleado.validar(sueldo);
        this.sueldo = sueldo;
    }

    @Override
    public String mostrarResumen() {
        return "[Empleado] " + getNombre() +
                " | Cargo: " + getCargo() +
                " | Sueldo: " + getSueldo();
    }

    /**
     * Devuelve una representacion textual completa del empleado, incluye datos personales y laborales
     * @return una cadena de texto con todos los datos formateados
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("%-10s %s\n","F.Ingreso:",fechaIngreso));
        if (cargo != null && !cargo.isEmpty()) {
            sb.append(String.format("%-10s %s\n","cargo:",cargo));
        }
        sb.append(String.format("%-10s %s\n","Depto.:",departamento));
        sb.append(String.format("%-10s %s\n","Sueldo:",sueldo));

        return sb.toString();
    }
}

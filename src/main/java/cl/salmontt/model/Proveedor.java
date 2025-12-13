package cl.salmontt.model;

import cl.salmontt.Interfaces.Registrable;
import cl.salmontt.util.ValidaRutException;

public class Proveedor extends Persona implements Registrable {

    private String giro;

    public Proveedor(){}

    public Proveedor(String nombre, String rut, Direccion direccion, String telefono, String email
            , String giro) throws ValidaRutException {
        super(nombre, rut, direccion, telefono, email);
        this.giro = giro;
    }

    public Proveedor(String nombre, String rut, String direccion, String comuna, String region, String telefono, String email
            , String giro) throws ValidaRutException {
        super(nombre, rut, direccion, comuna,region, telefono, email);
        this.giro = giro;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    @Override
    public String mostrarResumen() {
        return "[Proveedor] " + getNombre() +
                " | Giro: " + getGiro() +
                " | Rut: " + getRut().getTextoRut() +
                " | Teléfono: " + getTelefono();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("%-10s %s\n", "Giro:", giro));

        return sb.toString();
    }
}

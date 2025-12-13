package cl.salmontt.model;

import cl.salmontt.Interfaces.Registrable;
import cl.salmontt.util.ValidaRutException;

public class Cliente extends Persona implements Registrable {

    private String codigoCliente;
    private String tipoCliente;
    private Tarjeta tarjeta;

    public Cliente(String nombre, String rut, String codigoCliente, String tipoCliente, Tarjeta tarjeta ) throws ValidaRutException {
        super(nombre, rut, null, null, null);
        this.codigoCliente = codigoCliente;
        this.tipoCliente = tipoCliente;
        this.tarjeta = tarjeta;
    }

    public Cliente(String nombre, String rut, Direccion direccion, String telefono, String mail,
                   String codigoCliente, String tipoCliente, Tarjeta tarjeta) throws ValidaRutException {
        super(nombre, rut, direccion, telefono, mail);
        this.codigoCliente = codigoCliente;
        this.tipoCliente = tipoCliente;
        this.tarjeta = tarjeta;
    }

    public Cliente(String nombre, String rut, String direccion, String comuna, String region, String telefono, String mail,
                   String codigoCliente, String tipoCliente, Tarjeta tarjeta) throws ValidaRutException {
        super(nombre, rut, direccion, comuna, region, telefono, mail);
        this.codigoCliente = codigoCliente;
        this.tipoCliente = tipoCliente;
        this.tarjeta = tarjeta;
    }

    public String getCodigoCliente(){
        return codigoCliente;
    }

    public String getTipoCliente(){
        return tipoCliente;
    }
     public Tarjeta getTarjeta(){
        return tarjeta;
     }

    @Override
    public String mostrarResumen() {
        return "[Cliente] " + getNombre() +
                " | Tipo: " + getTipoCliente() +
                " | Tarjeta: " + getTarjeta().getNumeroTarjeta() +
                " | Banco: " + getTarjeta().getBanco();
    }

     @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("%-10s %s\n","Cod. Cliente:",codigoCliente));
        sb.append(String.format("%-10s %s\n","Tipo Cliente:",tipoCliente));
        sb.append(tarjeta).append("\n");
        return sb.toString();
     }
}

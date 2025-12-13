package cl.salmontt.model;

import java.util.HashMap;
import java.util.Map;

public class OrdenDeCompra {

    private String numeroOrden;
    private String fecha;
    private Cliente cliente;

    private Map<Producto, Integer> productoCantidad = new HashMap<>();

    public OrdenDeCompra(String numeroOrden, String fecha, Cliente cliente) {
        this.numeroOrden = numeroOrden;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public String getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Map<Producto, Integer> getProductoCantidad() {
        return productoCantidad;
    }

    public void agregarProducto (Producto producto, int cantidad){
        if (cantidad <=0){
            throw new IllegalArgumentException("La cantidad no puede ser menor o igual a 0");
        }
        productoCantidad.put(producto, cantidad);
    }

    public double getTotal(){
        double total = 0;
        for (Map.Entry<Producto, Integer> listado : productoCantidad.entrySet()){
            total += listado.getKey().getPrecioUnitario() * listado.getValue();
        }
        return total;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Orden N° ").append(numeroOrden)
                .append(" - Fecha: ").append(fecha).append("\n")
                .append(cliente)
                .append("------DETALLE DE LA COMPRA------\n");

        for (Map.Entry<Producto, Integer> listado : productoCantidad.entrySet()) {
            Producto prod = listado.getKey();
            int cant = listado.getValue();
            double sub = prod.getPrecioUnitario() * cant;
            sb.append(String.format("%sCant: %d\nSubtotal: %.2f\n", prod, cant, sub));
            sb.append("--------------------------------\n");
        }

        sb.append(String.format("TOTAL ORDEN: %.2f\n", getTotal()));
        return sb.toString();
    }
}

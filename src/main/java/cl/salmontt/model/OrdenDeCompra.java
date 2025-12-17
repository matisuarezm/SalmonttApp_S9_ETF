package cl.salmontt.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa una orden de compra realizada por un {@link Cliente} que agrupa uno o mas {@link Producto} con sus cantidades
 * y permite calcular el total a pagar
 * La orden almacena su numero identificado, fecha de emision, el cliente y el detalle de productos con sus cantidades.
 *
 * @author msuarez
 * @version 1.0
 */
public class OrdenDeCompra {

    private String numeroOrden;
    private String fecha;
    private Cliente cliente;

    /**
     * Detalle de la orden: mapa de productos y la cantidad solicitada de cada uno
     */
    private Map<Producto, Integer> productoCantidad = new HashMap<>();

    /**
     * Crea una nueva orden de compra con su número, fecha y cliente asociado
     * @param numeroOrden número identificador de la orden
     * @param fecha fecha de emision de la orden
     * @param cliente cliente que realiza la compra
     */
    public OrdenDeCompra(String numeroOrden, String fecha, Cliente cliente) {
        this.numeroOrden = numeroOrden;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    /**
     * Obtiene el numero de la orden
     * @return numero de orden
     */
    public String getNumeroOrden() {
        return numeroOrden;
    }

    /**
     * obtiene la fecha de emision de la orden
     * @return fecha de la orden
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Obtiene el cliente asociado a la orden
     * @return cliente de la orden
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Obtiene el mapa que contiene el detalle de la orden, donde cada clave es un {@link Producto} y el valor es la cantidad
     * @return mapa de productos y cantidades.
     */
    public Map<Producto, Integer> getProductoCantidad() {
        return productoCantidad;
    }

    /**
     * Agrega un producto al detale de la orden con la cantidad indicada, si el producto existe la cantidad se reemplaza por la nueva
     * @param producto producto a agregar
     * @param cantidad cantidad de productos, debe ser mayor a 0
     * @throws IllegalArgumentException si la cantidad es menor o igual a 0
     */
    public void agregarProducto (Producto producto, int cantidad){
        if (cantidad <=0){
            throw new IllegalArgumentException("La cantidad no puede ser menor o igual a 0");
        }
        productoCantidad.put(producto, cantidad);
    }

    /**
     * Calcula el total de la orden. Multiplicando el precio por la cantidad y sumando todos los subtotales
     * @return monto total de la orden
     */
    public double getTotal(){
        double total = 0;
        for (Map.Entry<Producto, Integer> listado : productoCantidad.entrySet()){
            total += listado.getKey().getPrecioUnitario() * listado.getValue();
        }
        return total;
    }

    /**
     * Devuelve una representacion textual de la orden de compra, incluyendo encabezado, datos del cliente, detalle de
     * productos con cantidad y subtotal, también el total general
     * @return cadena de texto con la descripción completa de una orden.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Orden N° ").append(numeroOrden)
                .append(" - Fecha: ").append(fecha).append("\n")
                .append(cliente)
                .append("\n------DETALLE DE LA COMPRA------\n");

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

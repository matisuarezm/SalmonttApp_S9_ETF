package cl.salmontt.services;

import cl.salmontt.model.Proveedor;

import java.util.ArrayList;
import java.util.List;

/**
 *  Servicio de negocio para operaciones de consulta sobre proveedores,
 *  como listados y búsquedas por nombre o RUT.
 *
 * @author msuarez
 * @version 1.0
 */
public class ProveedoresServices {

    /**
     * Muestra por consola todos los proveedores contenidos en la lista recibida.
     * @param listaProveedores lista de proveedores a imprimir
     */
    public void listarTodos(List<Proveedor> listaProveedores) {
        for (Proveedor proveedor : listaProveedores) {
            System.out.println(proveedor);
        }
    }

    /**
     * Busca proveedores por nombre exacto dentro de la lista proporcionada, la comparacion ignora espacios en blanco
     * al inicio y al final y no distingue mayusculas/minusculas
     * @param listaProveedores lista de proveedores donde se realizará la búsqueda
     * @param nombre nombre del proveedor a buscar
     * @return lista de proveedores cuyo nombre coincide con el valor indicado.
     */
    public List<Proveedor> buscarPorNombre(List<Proveedor> listaProveedores, String nombre) {
        List<Proveedor> resultado = new ArrayList<>();
        String LimpiaNombre = nombre.trim().toLowerCase();
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getNombre().trim().toLowerCase().equalsIgnoreCase(LimpiaNombre)) {
                resultado.add(proveedor);
            }
        }
        return resultado;
    }

    /**
     * Busca proveedores por RUT dentro de la lista proporcionada, la comparacion ignora espacios en blanco
     * al inicio y al final y no distingue mayusculas/minusculas
     * @param listaProveedores lista de proveedores donde se realizará la búsqueda
     * @param rut RUT a buscar en formato texto
     * @return lista de proveedores cuyo RUT coincide con el valor indicado.
     */
    public List<Proveedor> buscarPorRut(List<Proveedor> listaProveedores, String rut) {
        List<Proveedor> resultado = new ArrayList<>();
        String limpiaRut = rut.trim();
        for (Proveedor proveedor : listaProveedores) {
            if (proveedor.getRut().getTextoRut().trim().equalsIgnoreCase(limpiaRut)) {
                resultado.add(proveedor);
            }
        }
        return resultado;
    }
}

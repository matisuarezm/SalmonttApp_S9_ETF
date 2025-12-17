package cl.salmontt.services;

import cl.salmontt.model.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de negocio para operaciones de consulta sobre productos,
 * como listados y búsquedas por código o categoría.
 *
 * @author msuarez
 * @version 1.0
 */
public class ProductosServices {

    /**
     * Muestra por consola todos los productos contenidos en la lista recibida.
     * @param listaClientes lista de productos a imprimir
     */
    public void listarTodos(List<Producto> listaClientes) {
        for (Producto producto : listaClientes) {
            System.out.println(producto);
        }
    }

    /**
     * Busca productos por código dentro de la lista entregada, la comparacion ignora espacios en blanco
     * al inicio y al final y no distingue mayusculas/minusculas
     * @param listaClientes lista de productos donde se realizará la búsqueda
     * @param codigo código de producto a buscar
     * @return lista de productos cuyo código coincide con el valor indicado
     */
    public List<Producto> buscarPorCodigo(List<Producto> listaClientes, String codigo) {
        List<Producto> resultado = new ArrayList<>();
        String limpiaCodigo = codigo.trim();
        for (Producto producto : listaClientes) {
            if (producto.getCodigo().trim().equalsIgnoreCase(limpiaCodigo)) {
                resultado.add(producto);
            }
        }
        return resultado;
    }

    /**
     * Busca productos por categoría dentro de la lista proporcionada, la comparacion ignora espacios en blanco
     * al inicio y al final y no distingue mayusculas/minusculas.
     * @param listaClientes lista de productos donde se realizará la búsqueda.
     * @param categoria categoría de producto a buscar.
     * @return lista de productos cuya categoría coincide con el valor indicado.
     */
    public List<Producto> buscarPorCategoria(List<Producto> listaClientes, String categoria) {
        List<Producto> resultado = new ArrayList<>();
        String limpiaCategoria = categoria.trim();
        for (Producto producto : listaClientes) {
            if (producto.getCategoria().trim().equalsIgnoreCase(limpiaCategoria)) {
                resultado.add(producto);
            }
        }
        return resultado;
    }
}

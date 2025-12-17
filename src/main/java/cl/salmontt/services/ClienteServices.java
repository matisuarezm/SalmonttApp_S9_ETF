package cl.salmontt.services;

import cl.salmontt.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de negocio para operaciones de consulta sobre clientes
 *
 * @author msuarez
 * @version 1.0
 */
public class ClienteServices {

    /**
     * Muestra por consola todos los clientes contenidos en la lista recibida
     * @param listaClientes lista de clientes a imprimir
     */
    public void listarTodos(List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    /**
     * Busca clientes por nombre exacto dentro de la lista proporcionada, la comparacion ignora espacios en blanco
     * al inicio y al final y no distingue mayusculas/minusculas
     * @param listaClientes lista de clientes donde se realiza la busqueda
     * @param nombre nombre del cliente a buscar
     * @return lista de clientes cuyo nombre coincide con el valor indicado
     */
    public List<Cliente> buscarPorNombre(List<Cliente> listaClientes, String nombre) {
        List<Cliente> resultado = new ArrayList<>();
        String LimpiaNombre = nombre.trim().toLowerCase();
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().trim().toLowerCase().equals(LimpiaNombre)) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }

    /**
     * Busca clientes por RUT dentro de la lista entregada y la comparacion se realiza contra el texto del RUT almacenado
     * @param listaClientes lista de cliente donde se realiza la busqueda
     * @param rut RUT a buscar en formato texto
     * @return lista de clientes cuyo RUT coincide con el valor indicado
     */
    public List<Cliente> buscarPorRut(List<Cliente> listaClientes, String rut) {
        List<Cliente> resultado = new ArrayList<>();
        String limpiaRut = rut.trim();
        for (Cliente cliente : listaClientes) {
            if (cliente.getRut().getTextoRut().trim().equalsIgnoreCase(limpiaRut)) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }

    /**
     * Busca clientes por codigo interno dentro de la lista entregada, la comparacion ignora espacios en blanco
     * al inicio y al final y no distingue mayusculas/minusculas
     * @param listaClientes lista de cliente donde se realiza la busqueda
     * @param codigo codigo del cliente a buscar
     * @return lista de clientes cuyo codigo coincide con el valor indicado
     */
    public List<Cliente> buscarPorCodigo(List<Cliente> listaClientes, String codigo) {
        List<Cliente> resultado = new ArrayList<>();
        String limpiaCodigo = codigo.trim();
        for (Cliente cliente : listaClientes) {
            if (cliente.getCodigoCliente().trim().equalsIgnoreCase(limpiaCodigo)) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }

}

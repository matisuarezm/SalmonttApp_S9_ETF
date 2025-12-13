package cl.salmontt.data;

import cl.salmontt.model.Cliente;
import cl.salmontt.model.Tarjeta;
import cl.salmontt.util.ValidaRutException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GestorClientes {

    public List<Cliente> cargaClientesTxt(String nombreArchivo) {

        List<Cliente> listaClientes = new ArrayList<>();

        ClassLoader classLoader = getClass().getClassLoader();

        try {
            InputStream lecturaArchivo = classLoader.getResourceAsStream(nombreArchivo);
            if (lecturaArchivo == null) {
                System.err.println("No se encontró el archivo " + nombreArchivo);
                return listaClientes;
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(lecturaArchivo))) {
                String lineaArchivo;
                int numeroLinea = 0;

                while ((lineaArchivo = br.readLine()) != null) {
                    numeroLinea++;
                    if (lineaArchivo.trim().isEmpty()) {
                        continue;
                    }
                    String[] fila = lineaArchivo.split(";");
                    if (fila.length != 13) {
                        System.err.println("La Linea " + numeroLinea + " no tiene el formato esperado o es invalida");
                        continue;
                    }

                    String nombre = fila[0].trim();
                    String rut = fila[1].trim();
                    String direccion = fila[2].trim();
                    String comuna = fila[3].trim();
                    String region = fila[4].trim();
                    String telefono = fila[5].trim();
                    String email = fila[6].trim();
                    String codigoCliente = fila[7].trim();
                    String tipoCliente = fila[8].trim();
                    String banco = fila[9].trim();
                    String tipoTarjeta = fila[10].trim();
                    String numeroTarjeta = fila[11].trim();
                    String fechaVencimiento = fila[12].trim();

                    try {
                        Tarjeta tarjeta = new Tarjeta(banco, numeroTarjeta, tipoTarjeta, fechaVencimiento);
                        Cliente cliente = new Cliente(nombre, rut, direccion, comuna, region, telefono, email, codigoCliente, tipoCliente, tarjeta);
                        listaClientes.add(cliente);
                    } catch (ValidaRutException e) {
                        System.out.println("RUT inválido en la línea " + numeroLinea + ": " + rut);
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error en la lectura del archivo");
        }
        return listaClientes;
    }

    //Mostrar todos los empleados
    public void listarTodos(List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }
    }

    //Mostrar empleados por Nombre
    public List<Cliente> buscarPorNombre(List<Cliente> listaClientes, String nombre) {
        List<Cliente> resultado = new ArrayList<>();
        String LimpiaNombre = nombre.trim().toLowerCase();
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().toLowerCase().equalsIgnoreCase(LimpiaNombre)) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }

    //Mostrar empleados por RUT
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

    //Mostrar empleados por Codigo
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
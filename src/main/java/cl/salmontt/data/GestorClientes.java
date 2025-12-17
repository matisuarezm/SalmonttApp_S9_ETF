package cl.salmontt.data;

import cl.salmontt.model.Cliente;
import cl.salmontt.model.Tarjeta;
import cl.salmontt.util.ValidaRutException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestor responsable de cargar clientes desde un archivo de texto y construir la lista de {@link Cliente}
 * El archivo debe estar disponible en el classpath y tener un formato de columnas separado por punto y coma (;)
 * este debe ser acorde al modelo de {@link Cliente} y {@link Tarjeta}
 *
 * @author msuarez
 * @version 1.0
 */
public class GestorClientes {

    /**
     * Carga clientes desde un archivo de texto y genera una lista de objetos {@link Cliente} para el uso del sistema.
     * Cada línea válida del archivo debe tener 13 campos separados por punto y coma (;)
     * @param nombreArchivo nombre del archivo que contiene la información del cliente
     * @return lista de clientes construida a partir del archivo
     */
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
}
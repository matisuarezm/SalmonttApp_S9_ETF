package cl.salmontt.data;

import cl.salmontt.model.Proveedor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestor responsable de cargar proveedores desde un archivo de texto y construir la lista de {@link Proveedor}
 * El archivo debe estar disponible en el classpath y tener un formato de columnas separado por punto y coma (;)
 * este debe ser acorde al modelo de {@link Proveedor}
 *
 * @author msuarez
 * @version 1.0
 */
public class GestorProveedores {

    /**
     * Carga proveedor desde un archivo de texto y genera una lista de objetos {@link Proveedor} para el uso del sistema.
     * Cada línea válida del archivo debe tener 8 campos separados por punto y coma (;)
     * @param nombreArchivo nombre del archivo que contiene la información del proveedor
     * @return lista de proveedores construida a partir del archivo
     */
    public List<Proveedor> cargaProveedoresTxt(String nombreArchivo) {

        List<Proveedor> listaProveedores = new ArrayList<>();

        ClassLoader classLoader = getClass().getClassLoader();

        try {
            InputStream lecturaArchivo = classLoader.getResourceAsStream(nombreArchivo);
            if (lecturaArchivo == null) {
                System.err.println("No se encontró el archivo " + nombreArchivo);
                return listaProveedores;
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
                    if (fila.length != 8) {
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
                    String giro = fila[7].trim();

                    Proveedor proveedor = new Proveedor(nombre, rut, direccion, comuna, region, telefono, email, giro);
                    listaProveedores.add(proveedor);
                }
            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error en la lectura del archivo");
        }
        return listaProveedores;
    }
}
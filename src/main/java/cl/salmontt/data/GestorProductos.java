package cl.salmontt.data;

import cl.salmontt.model.Producto;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestor responsable de cargar productos desde un archivo de texto y construir la lista de {@link Producto}
 * El archivo debe estar disponible en el classpath y tener un formato de columnas separado por punto y coma (;)
 * este debe ser acorde al modelo de {@link Producto}
 *
 * @author msuarez
 * @version 1.0
 */
public class GestorProductos {

    /**
     * Carga productos desde un archivo de texto y genera una lista de objetos {@link Producto} para el uso del sistema.
     * Cada línea válida del archivo debe tener 4 campos separados por punto y coma (;)
     * @param nombreArchivo nombre del archivo que contiene la información de los productos
     * @return lista de productos construida a partir del archivo
     */
    public List<Producto> cargaProductosTxt(String nombreArchivo) {

        List<Producto> listaProductos = new ArrayList<>();

        ClassLoader classLoader = getClass().getClassLoader();

        try {
            InputStream lecturaArchivo = classLoader.getResourceAsStream(nombreArchivo);
            if (lecturaArchivo == null) {
                System.err.println("No se encontró el archivo " + nombreArchivo);
                return listaProductos;
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
                    if (fila.length != 4) {
                        System.err.println("La Linea " + numeroLinea + " no tiene el formato esperado o es invalida");
                        continue;
                    }

                    String codigo = fila[0].trim();
                    String nombre = fila[1].trim();
                    String categoria = fila[2].trim();
                    String precio = fila[3].trim();

                    try {
                        double unitario = Double.parseDouble(precio);
                        Producto productos = new Producto(codigo, nombre, categoria, unitario);
                        listaProductos.add(productos);
                    }catch (NumberFormatException exception){
                        //Mensaje en caso de que la cantidad no se pueda convertir en numero
                        System.err.println("La cantidad de la linea " + lineaArchivo + " no corresponden a un número");
                    }

                }
            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error en la lectura del archivo");
        }
        return listaProductos;
    }
}
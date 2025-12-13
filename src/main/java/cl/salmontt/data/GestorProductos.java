package cl.salmontt.data;

import cl.salmontt.model.Producto;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GestorProductos {

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

    //Mostrar todos los empleados
    public void listarTodos(List<Producto> listaClientes) {
        for (Producto producto : listaClientes) {
            System.out.println(producto);
        }
    }

    //Mostrar empleados por Codigo
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

    //Mostrar empleados por categoria
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
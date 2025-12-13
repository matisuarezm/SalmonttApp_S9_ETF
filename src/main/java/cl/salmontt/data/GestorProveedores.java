package cl.salmontt.data;

import cl.salmontt.model.Proveedor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GestorProveedores {

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

    //Mostrar todos los empleados
    public void listarTodos(List<Proveedor> listaProveedores) {
        for (Proveedor proveedor : listaProveedores) {
            System.out.println(proveedor);
        }
    }

    //Mostrar empleados por Nombre
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

    //Mostrar empleados por RUT
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
package cl.salmontt.data;

import cl.salmontt.model.Empleado;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestor responsable de cargar empleados desde un archivo de texto y construir la lista de {@link Empleado}
 * El archivo debe estar disponible en el classpath y tener un formato de columnas separado por punto y coma (;)
 * este debe ser acorde al modelo de {@link Empleado}
 *
 * @author msuarez
 * @version 1.0
 */
public class GestorEmpleados {

    /**
     * Carga empleado desde un archivo de texto y genera una lista de objetos {@link Empleado} para el uso del sistema.
     * Cada línea válida del archivo debe tener 11 campos separados por punto y coma (;)
     * @param nombreArchivo nombre del archivo que contiene la información de los empleados
     * @return lista de empleados construida a partir del archivo
     */
    public List<Empleado> cargaEmpleadosTxt(String nombreArchivo){

        List<Empleado> listaEmpleados = new ArrayList<>();

        ClassLoader classLoader = getClass().getClassLoader();

        try {
            InputStream lecturaArchivo = classLoader.getResourceAsStream(nombreArchivo);
            if (lecturaArchivo == null){
                System.err.println("No se encontró el archivo " + nombreArchivo);
                return listaEmpleados;
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
                    if (fila.length != 11) {
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
                    String fechaIngreso = fila[7].trim();
                    String cargo = fila[8].trim();
                    String departamento = fila[9].trim();
                    String SueldoStr = fila[10].trim();

                    try {
                        double sueldo = Double.parseDouble(SueldoStr);
                        listaEmpleados.add(new Empleado(nombre, rut, direccion, comuna, region, telefono, email, fechaIngreso, cargo,departamento,sueldo));
                    } catch (NumberFormatException exception) {
                        //Mensaje en caso de que la cantidad no se pueda convertir en numero
                        System.err.println("El sueldo de la linea " + lineaArchivo + " no corresponden a un número");
                    }
                }
            }
        }catch (Exception ex){
            System.err.println("Ocurrió un error en la lectura del archivo");
        }
        return listaEmpleados;
    }
}

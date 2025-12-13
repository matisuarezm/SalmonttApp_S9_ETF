package cl.salmontt.data;

import cl.salmontt.model.Empleado;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {

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

    //Mostrar todos los empleados
    public void listarTodos(List<Empleado> listaEmpleados){
        for (Empleado empleado : listaEmpleados){
            System.out.println(empleado);
        }
    }

    //Mostrar empleados por Nombre
    public List<Empleado> buscarPorNombre(List<Empleado> listaEmpleados, String nombre){
        List<Empleado> resultado = new ArrayList<>();
        String LimpiaNombre = nombre.trim().toLowerCase();
        for (Empleado empleado : listaEmpleados){
            if (empleado.getNombre().equalsIgnoreCase(nombre)){
                resultado.add(empleado);
            }
        }
        return resultado;
    }

    //Mostrar empleados por RUT
    public List<Empleado> buscarPorRut(List<Empleado> listaEmpleados, String rut){
        List<Empleado> resultado = new ArrayList<>();
        String limpiaRut = rut.trim();
        for (Empleado empleado :listaEmpleados){
            if (empleado.getRut().getTextoRut().equalsIgnoreCase(rut)){
                resultado.add(empleado);
            }
        }
        return resultado;
    }

    //Mostrar empleados por Departamento
    public List<Empleado> buscarPorDepartamento(List<Empleado> listaEmpleados, String departamento) {
        List<Empleado> resultado = new ArrayList<>();
        String limpiaDepto = departamento.trim().toLowerCase();
        for (Empleado empleado : listaEmpleados){
            if (empleado.getDepartamento().equalsIgnoreCase(limpiaDepto)){
                resultado.add(empleado);
            }
        }
        return resultado;
    }

    //Mostrar empleados por Cargo
    public List<Empleado> buscarporCargo(List<Empleado> listaEmpleados, String cargo){
        List<Empleado> resultado = new ArrayList<>();
        String limpiaCargo = cargo.trim().toLowerCase();
        for (Empleado empleado : listaEmpleados){
            if (empleado.getCargo().equalsIgnoreCase(limpiaCargo)) {
                resultado.add(empleado);
            }
        }
        return resultado;
    }

    //Mostrar empleados por sueldo sobre un monto
    public List<Empleado> sueldoMayorA(List<Empleado> listaEmpleados, double sueldo){
        List<Empleado> resultado = new ArrayList<>();
        for (Empleado empleado : listaEmpleados){
            if (empleado.getSueldo() > sueldo){
                resultado.add(empleado);
            }
        }
        return resultado;
    }
}

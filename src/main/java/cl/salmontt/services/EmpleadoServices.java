package cl.salmontt.services;

import cl.salmontt.model.Empleado;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de negocio para operaciones de consulta sobre empleados
 */
public class EmpleadoServices {

    /**
     * Muestra todos los empleados contenidos en la lista recibida
     * @param listaEmpleados lista de empleados a imprimir
     */
    public void listarTodos(List<Empleado> listaEmpleados){
        for (Empleado empleado : listaEmpleados){
            System.out.println(empleado);
        }
    }

    /**
     * Busca empleados por el nombre exacto dentor de la lista entregada
     * @param listaEmpleados lista recibida donde se genera la busqueda
     * @param nombre nombre del empleado a buscar
     * @return lista de empleados cuyo nombre coincide con el valor indicado
     */
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

    /**
     * Busca empleados por RUT dentro de una lista entregada, la comparacion ignora espacios en blanco
     * al inicio y al final y no distingue mayusculas/minusculas
     * @param listaEmpleados Lista de empleados donde se realiza la busqueda
     * @param rut rut a buscar en formato texto
     * @return lista de empleados cuyo RUT donde coincide el valor indicado.
     */
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

    /**
     * Busca empleados por departamento dentro de la lista entregada, la comparacion ignora espacios en blanco
     * al inicio y al final y no distingue mayusculas/minusculas
     * @param listaEmpleados Lista donde se realiza la busqueda
     * @param departamento nombre del departamento a buscar
     * @return lista de empleados cuyo departamento coincida con el valor indicado
     */
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

    /**
     * Busca empleado por cargo dentro de la lista proporcionada, la comparacion ignora espacios en blanco
     * al inicio y al final y no distingue mayusculas/minusculas
     * @param listaEmpleados lista de empleados donde se realizará la busqueda
     * @param cargo nombre del cargo a buscar
     * @return lista de empleados cuyo cargo coincide con el valor indicado
     */
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

    /**
     * Obtiene todos los empleados cuyo sueldo es estrictamente mayor al monto indicado
     * @param listaEmpleados lista de empleados donde se realizara el filtro
     * @param sueldo monto de referencia para compara sueldos
     * @return lista de empleados cuyo sueldo es mayor al valor indicado
     */
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

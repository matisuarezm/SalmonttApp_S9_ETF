package cl.salmontt.data;

import cl.salmontt.model.Empleado;
import cl.salmontt.util.ValidaFormatoCelda;
import cl.salmontt.util.ValidaRutException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {

    private final List<Empleado> listaEmpleados = new ArrayList<>();

    public void cargarDesdeExcel(InputStream archivoALeer){
        try (XSSFWorkbook libro = new XSSFWorkbook(archivoALeer)){
            XSSFSheet hoja = libro.getSheetAt(0); //Primera hoja del Excel

            //procesamos las filas sin incluir encabezados, for parte de fila 1.
            //get.LastRowNum(), devuelve el numero de la última fila de la hoja que contiene datos
            for (int i = 1; i <= hoja.getLastRowNum(); i++) {
                var fila = hoja.getRow(i);

                if (fila == null) continue; //omitimos las filas vacías

                try {
                    //Leer datos de Persona
                    String nombre = ValidaFormatoCelda.validarString(fila.getCell(0));
                    //String apellido = ValidaFormatoCelda.validarString(fila.getCell(1));
                    String rut = ValidaFormatoCelda.validarString(fila.getCell(2));

                    //Leer Direccion
                    String calle = ValidaFormatoCelda.validarString(fila.getCell(3));
                    //int numero = ValidaFormatoCelda.validarInt(fila.getCell(4));
                    //String casaDepartamento = ValidaFormatoCelda.validarString(fila.getCell(5));
                    String comuna = ValidaFormatoCelda.validarString(fila.getCell(6));
                    String region = ValidaFormatoCelda.validarString(fila.getCell(7));

                    //Leer Contacto
                    String telefono = ValidaFormatoCelda.validarString(fila.getCell(8));

                    //Leer datos Laborales
                    String fechaIngreso = ValidaFormatoCelda.validarFechaString(fila.getCell(9),"dd-MM-yyyy");
                    String cargo = ValidaFormatoCelda.validarString(fila.getCell(10));
                    String departamento = ValidaFormatoCelda.validarString(fila.getCell(11));
                    String mail = ValidaFormatoCelda.validarString(fila.getCell(12));
                    double sueldo = ValidaFormatoCelda.validarDouble(fila.getCell(13));

                    //Creamos objeto Empleado con  todos sus parámetros
                    Empleado empleado = new Empleado(
                            nombre, rut,
                            calle, comuna, region,
                            telefono, mail, fechaIngreso, cargo, departamento, sueldo
                    );

                    //Agregamos a la listaEmpleados la linea leida
                    agregarALista(empleado);

                }catch (ValidaRutException e){
                    System.out.println("Error en la fila " + (i+1) + ": " + e.getMessage());
                }catch (Exception e){
                    System.out.println("Error al procesar fila " + (i+1) + ": " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al abrir el archivo: " + e.getMessage());
        }
    }

    //Agrega a listaEmpleado
    public void agregarALista(Empleado empleado){
        listaEmpleados.add(empleado);
    }

    //Mostrar todos los empleados
    public void listarTodos(){
        for (Empleado empleado : listaEmpleados){
            System.out.println(empleado);
        }
    }

    //Mostrar empleados por Nombre
    public List<Empleado> buscarPorNombre(String nombre){
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
    public List<Empleado> buscarPorRut(String rut){
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
    public List<Empleado> buscarPorDepartamento(String departamento) {
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
    public List<Empleado> buscarporCargo(String cargo){
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
    public List<Empleado> sueldoMayorA(double sueldo){
        List<Empleado> resultado = new ArrayList<>();
        for (Empleado empleado : listaEmpleados){
            if (empleado.getSueldo() > sueldo){
                resultado.add(empleado);
            }
        }
        return resultado;
    }
}

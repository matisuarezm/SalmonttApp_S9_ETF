package cl.salmontt.services;

import cl.salmontt.Interfaces.Registrable;
import cl.salmontt.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio encargado de administrar un registro polimórfico de entidades
 * que implementan {@link Registrable}, como centros, plantas, empleados,
 * clientes y proveedores.
 *
 * @author msuarez
 * @version 1.0
 */
public class EntidadesServices {

    private final List<Registrable> registros;

    /**
     * Crea un servicio de entidades con la lista interna inicializada vacía.
     */
    public EntidadesServices(){
        this.registros = new ArrayList<>();
    }

    /**
     * Agrega un nuevo registro a la colección de entidades.
     * @param reg entidad que implementa {@link Registrable} a agregar
     */
    public void agregarRegistro (Registrable reg){
        reg.registrar();
        registros.add(reg);
        //System.out.println(reg.toString());
    }

    /**
     * Obtiene la lista completa de entidades registradas.
     * @return lista de objetos que implementan {@link Registrable}
     */
    public List<Registrable> getRegistros(){
        return registros;
    }

    /**
     * Muestra por consola el resumen de todas las entidades registradas
     * Cada entidad se visualiza mediante su método {@link Registrable#mostrarResumen()}.
     */
    public void visualizarRegistro(){
        for (Registrable reg : registros){
            if (reg instanceof CentroCultivo centroCultivo){
                System.out.println(centroCultivo.mostrarResumen());
            } else if (reg instanceof PlantaProceso plantaProceso) {
                System.out.println(plantaProceso.mostrarResumen());
            }else if (reg instanceof Proveedor proveedor){
                System.out.println(proveedor.mostrarResumen());
            } else if (reg instanceof Empleado empleado) {
                System.out.println(empleado.mostrarResumen());
            } else if (reg instanceof Cliente cliente) {
                System.out.println(cliente.mostrarResumen());
            }
        }
        System.out.println();
    }

    /**
     * Construye una representación textual detallada de todas las entidades registradas
     * @return cadena de texto con la información de todas las entidades formateada línea a línea
     */
    public String listarTodos(){
        StringBuilder sb = new StringBuilder();
        for (Registrable reg : registros){
            sb.append(reg.toString()).append('\n');
        }
        return sb.toString();
    }

}

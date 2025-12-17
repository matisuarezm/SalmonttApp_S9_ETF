package cl.salmontt.util;

import cl.salmontt.data.*;
import cl.salmontt.model.*;
import cl.salmontt.services.*;

import java.util.List;
import java.util.Scanner;

/**
 * Clase de utilidad para la interfaz de consola de la aplicación. Centraliza la carga de información desde archivos TXT, la inicialización
 * de gestores y servicios, y las operaciones comunes del menú principal, como mostrar opciones, salir del sistema y preguntar si se desea continuar.
 *
 * @author msuarez
 * @version 1.0
 */
public class UtilidadConsola {

    /** Gestor para cargar unidades operativas desde TXT. */
    public static GestorUnidades gestorUnidades = new GestorUnidades();
    /** Servicio polimórfico para administrar entidades registrables. */
    public static EntidadesServices entidadesServices = new EntidadesServices();
    /** Gestor para cargar empleados desde TXT. */
    public static GestorEmpleados gestorEmpleados = new GestorEmpleados();
    /** Gestor para cargar clientes desde TXT. */
    public static GestorClientes gestorClientes   = new GestorClientes();
    /** Gestor para cargar proveedores desde TXT. */
    public static GestorProveedores gestorProveedores = new GestorProveedores();
    /** Gestor para cargar productos desde TXT. */
    public static GestorProductos gestorProductos = new GestorProductos();

    /** Servicio de negocio para consultas sobre clientes. */
    public static ClienteServices clienteServices = new ClienteServices();
    /** Servicio de negocio para consultas sobre productos. */
    public static EmpleadoServices empleadoServices = new EmpleadoServices();
    /** Servicio de negocio para consultas sobre proveedores. */
    public static ProveedoresServices proveedoresServices = new ProveedoresServices();
    /** Servicio de negocio para consultas sobre unidades operativas. */
    public static UnidadesServices unidadesServices = new UnidadesServices();
    /** Servicio de negocio para consultas sobre productos. */
    public static ProductosServices productosServices = new ProductosServices();

    /** Lista de empleados cargados desde archivo. */
    public static List<Empleado> empleados;
    /** Lista de clientes cargados desde archivo. */
    public static List<Cliente> clientes;
    /** Lista de proveedores cargados desde archivo. */
    public static List<Proveedor> proveedores;
    /** Lista de unidades operativas cargadas desde archivo. */
    public static List<UnidadOperativa> unidades;
    /** Lista de productos cargados desde archivo. */
    public static List<Producto> productos;

    /**
     * Carga todas las entidades de la aplicación desde archivos de texto, ubicados en el classpath (unidades, empleados, clientes, proveedores y productos)
     * y alimenta el repositorio polimórfico de entidades registrables.
     */
    public static void cargaInformacionTxt(){

        //UnidadeOperativa -> Agregamos los objetos del txt a Registrable
        unidades = gestorUnidades.cargarUnidadesDesdeTxt("PlantasYCentrosCultivo.txt");
        entidadesServices.getRegistros().addAll(unidades);

        //Empleados -> Agregamos los objetos del txt a Registrable
        empleados = gestorEmpleados.cargaEmpleadosTxt("Empleados.txt");
        entidadesServices.getRegistros().addAll(empleados); // Empleado implements Registrable

        //Clientes -> Agregamos los objetos del txt a Registrable
        clientes = gestorClientes.cargaClientesTxt("Clientes.txt");
        entidadesServices.getRegistros().addAll(clientes);

        //Proveedores -> Agregamos los objetos del txt a Registrable
        proveedores = gestorProveedores.cargaProveedoresTxt("Proveedores.txt");
        entidadesServices.getRegistros().addAll(proveedores);

        //Productos -> -> Agregamos los objetos del txt a Registrable
        productos = gestorProductos.cargaProductosTxt("Productos.txt");
    }

    /**
     * Crea y muestra por consola una orden de compra de prueba, utilizando un cliente y dos productos ya cargados en memoria.
     */
    public static void ordenPrueba(){
        if (clientes.isEmpty() || productos.size() <=0) {
            System.out.println("No hay datos suficientes para crear una orden");
            return;
        }

        Cliente cliente1 = clientes.get(2);
        Producto producto1 = productos.get(0);
        Producto producto2 = productos.get(1);

        OrdenDeCompra orden = new OrdenDeCompra("OC-001", "13-12-2025", cliente1);
        orden.agregarProducto(producto1, 10);
        orden.agregarProducto(producto2, 5);

        System.out.println(orden);
    }

    /**
     * Muestra en consola el menú principal de la aplicación Salmontt.
     */
    public static void MenuPrincipal(){
        System.out.println("====--->>> SALMONTT APP <<<---====");
        System.out.println("1.- Listar todas las entidades (Registrables)");
        System.out.println("2.- Buscar empleados por Nombre");
        System.out.println("3.- Buscar clientes por código");
        System.out.println("4.- Listar productos");
        System.out.println("5.- Crear Orden de Compra");
        System.out.println("9.- Salir");
        System.out.print("\nSeleccione una opción del Menú: ");
    }

    /**
     * Muestra un mensaje de salida del sistema con una breve animación de puntos.
     */
    public static void salirMenuPrincipal(){
        System.out.println("Usted esta saliendo del sistema");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print(".");
        }
        System.out.println("\nGracias por usar el programa.!!!");
    }

    /**
     * Pregunta al usuario por consola si desea realizar otra operación, aceptando solo las opciones S (sí) o N (no).
     * @param input instancia de {@link Scanner} utilizada para leer desde consola
     * @return {@code true} si el usuario responde S, {@code false} si responde N
     */
    public static boolean deseaContinuar(Scanner input){
        while(true) {
            System.out.print("¿Desea hace alguna otra operación? S/N: ");
            String letra = input.nextLine().trim().toUpperCase();
            if (letra.equals("S")) return true;
            if (letra.equals("N")) return false;
            System.out.println("Error. Ingrese la letra correspondiente S ó N");
        }
    }

}

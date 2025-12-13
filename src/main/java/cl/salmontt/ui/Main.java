package cl.salmontt.ui;

import cl.salmontt.data.GestorClientes;
import cl.salmontt.data.GestorEmpleados;
import cl.salmontt.data.GestorProductos;
import cl.salmontt.model.Cliente;
import cl.salmontt.model.Empleado;
import cl.salmontt.model.OrdenDeCompra;
import cl.salmontt.model.Producto;

import  java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
        System.out.println("Inciando SalmonttAPP");
        SalmonttAppFrame ventana = new SalmonttAppFrame();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);


        GestorEmpleados gestor = new GestorEmpleados();

        // 1) Cargar desde TXT (ubicado en src/main/resources)
        List<Empleado> empleados = gestor.cargaEmpleadosTxt("empleados.txt");


        // 2) Mostrar todos
        System.out.println("=== TODOS LOS EMPLEADOS ===");
        gestor.listarTodos(empleados);

        // 3) Probar búsquedas
        System.out.println("\n=== BUSCAR POR NOMBRE: 'Juan Pérez' ===");
        gestor.buscarPorNombre(empleados,"Juan Perez")
                .forEach(System.out::println);

        System.out.println("\n=== BUSCAR POR RUT: '11111111-1' ===");
        gestor.buscarPorRut(empleados, "17404347-7")
                .forEach(System.out::println);

        System.out.println("\n=== EMPLEADOS CON SUELDO > 1_000_000 ===");
        gestor.sueldoMayorA(empleados,600000)
                .forEach(System.out::println);


        GestorClientes gestorClientes = new GestorClientes();
        List<Cliente> clientes = gestorClientes.cargaClientesTxt("clientes.txt");

        gestorClientes.listarTodos(clientes);

        gestorClientes.buscarPorNombre(clientes, "Gustavo Guerra ")
                .forEach(System.out::println);

        gestorClientes.buscarPorCodigo(clientes, "C0100")
                .forEach(System.out::println);

         */

        GestorClientes gestorClientes = new GestorClientes();
        List<Cliente> clientes = gestorClientes.cargaClientesTxt("Clientes.txt");

        GestorProductos gestorProductos = new GestorProductos();
        List<Producto> productos = gestorProductos.cargaProductosTxt("Productos.txt");

        Cliente c1 = clientes.get(0);
        Producto p1 = productos.get(0);
        Producto p2 = productos.get(1);

        OrdenDeCompra orden = new OrdenDeCompra("OC-001", "13-12-2025", c1);
        orden.agregarProducto(p1, 10);
        orden.agregarProducto(p2, 5);

        System.out.println(orden);
    }
}
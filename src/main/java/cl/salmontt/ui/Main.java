package cl.salmontt.ui;

import cl.salmontt.model.Cliente;
import cl.salmontt.model.Empleado;
import cl.salmontt.util.UtilidadConsola;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        UtilidadConsola.cargaInformacionTxt();
        Scanner input = new Scanner(System.in);
        int opcionMenu = 0;

        do {
            UtilidadConsola.MenuPrincipal();
            try {
                opcionMenu = input.nextInt();
                input.nextLine();

                switch (opcionMenu){
                    case 1:
                        System.out.println("==== ENTIDADES REGISTRABLES ====");
                        UtilidadConsola.entidadesServices.visualizarRegistro();
                        break;
                    case 2:
                        System.out.print("Ingrese nombre de empleado: ");
                        String nombreEmp = input.nextLine();
                        List<Empleado> empleadoEncontrado = UtilidadConsola.empleadoServices.buscarPorNombre(UtilidadConsola.empleados, nombreEmp);
                        if (empleadoEncontrado.isEmpty()){
                            System.out.println("No se encontró el empleado con nombre:" + nombreEmp);
                        }else{
                            for (Empleado emp : empleadoEncontrado){
                                System.out.println(emp);
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese código de cliente: ");
                        String codCli = input.nextLine();

                        List<Cliente> clienteEncontrado = UtilidadConsola.clienteServices.buscarPorCodigo(UtilidadConsola.clientes, codCli);

                        if (clienteEncontrado.isEmpty()){
                            System.out.println("No se encontró ningún cliente con el código: " + codCli);
                        }else{
                            for (Cliente cli : clienteEncontrado){
                                System.out.println(cli);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("==== PRODUCTOS ====");
                        UtilidadConsola.productosServices.listarTodos(UtilidadConsola.productos);
                        break;
                    case 5:
                        UtilidadConsola.ordenPrueba();
                        break;
                    case 9:
                        UtilidadConsola.salirMenuPrincipal();
                        break;
                    default:
                        System.out.println("Opción ingresada inválida, Intente nuevamente");
                }

                if (opcionMenu != 9){
                    if (!UtilidadConsola.deseaContinuar(input)) {
                        opcionMenu = 9;
                        UtilidadConsola.salirMenuPrincipal();
                    }
                }

            }catch(InputMismatchException e){
                System.err.println("Error.. Entrada inválida, Por favor ingrese una opción del Menú");
                input.nextLine();
                opcionMenu = 0;
            }
        }while (opcionMenu != 9);
        input.close();
    }
}
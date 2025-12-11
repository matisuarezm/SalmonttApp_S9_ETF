package cl.salmontt.util;

import java.util.Scanner;

public class UtilidadConsola {

    public static void MenuPrincipal(){
        System.out.println("====--->>> SALMONTT APP <<<---====");
        System.out.println("1.- Mostrar Centros de Cultivos");
        System.out.println("2.- Mostrar Plantas de Proceso");
        System.out.println("3.- Listar Todos");
        System.out.println("9.- Salir");
        System.out.print("\nSeleccione una opción del Menú: ");
    }

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

package cl.salmontt.util;

import javax.swing.*;

public class ValidaSueldoEmpleado {

    /**
     * Método que valida que el sueldo sea mayor 0
     * @param sueldo Sueldo mensual
     * @throws IllegalArgumentException si el sueldo es negativo
     */
    public static void validar(double sueldo){

        final double SUELDO_MINIMO = 529000.0;
        final double SUELDO_MAXIMO = 10000000.0;

        if (sueldo < 0){
            throw new IllegalArgumentException("El sueldo no puede ser menor a 0.");
            //JOptionPane.showMessageDialog(null,"El sueldo no puede ser menor a 0.");
        }

        if (sueldo >= 0 && sueldo < SUELDO_MINIMO){
            throw new IllegalArgumentException("El sueldo no puede ser menor al mínimo legal");
            //JOptionPane.showMessageDialog(null,"El sueldo no puede ser menor al mínimo legal");
        }

        if (sueldo > SUELDO_MAXIMO){
            throw new IllegalArgumentException("El sueldo es demasiado alto, verifica la información");
            //JOptionPane.showMessageDialog(null,"El sueldo es demasiado alto, verifica la información");
        }
    }
}

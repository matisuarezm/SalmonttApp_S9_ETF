package cl.salmontt.util;

/**
 * Clase de utilidad para validar el sueldo de los empleados de la empresa Salmontt.
 * Aplica las reglas de negocio definidas para los sueldos mínimos y máximos
 *
 * @author msuarez
 * @version 1.0
 */
public class ValidaSueldoEmpleado {

    /**
     * Valida que el sueldo cumpla con las reglas de negocio definidas:
     * mayor o igual al sueldo mínimo legal y menor o igual al máximo permitido.
     * @param sueldo Sueldo mensual
     * @throws IllegalArgumentException si el sueldo es negativo o incumple requisitos legales
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

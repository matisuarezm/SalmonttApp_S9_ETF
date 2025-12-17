package cl.salmontt.model;

/**
 * Representa una planta de proceso como unidad operativa, incluyendo informacion basica y la capacidad de procesamiento diaria
 * Extiende a {@link UnidadOperativa} y puede ser utilizada en listados y reportes.
 *
 * @author msuarez
 * @version 1.0
 */
public class PlantaProceso extends UnidadOperativa{

    private final double capacidadProceso;

    /**
     * Crea una planta de procesos con sus datos basico y su capacidad de procesamiento
     * @param id identificado interno de la unidad operativa
     * @param tipo tipo de unidad (Centro o Planta)
     * @param nombre nombre de la planta de proceso
     * @param comuna comuna donde se encuentra la planta
     * @param capacidadProceso capacidad de procesamiento de la planta
     */
    public PlantaProceso(String id, String tipo, String nombre, String comuna, double capacidadProceso) {
        super(id, tipo, nombre, comuna);
        this.capacidadProceso = capacidadProceso;
    }

    /**
     * Obtiene la capacidad de procesamiento de la planta
     * @return capacidad de proceso
     */
    public double getCapacidadProceso(){
        return capacidadProceso;
    }

    /**
     * Muestra por consola el detalle completo de la planta de proceso en un formato legible para el usuario.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("***********************");
        System.out.println("   PLANTA DE PROCESO   ");
        System.out.println("***********************");
        System.out.println(this.toString());
        System.out.println();
    }

    /**
     * {@inheritDoc}
     * En este caso, el resumen incluye el tipo, nombre y la capacidad de procesamiento de la planta
     * @return cadena con un resumen de la planta de proceso
     */
    @Override
    public String mostrarResumen() {
        return "[" + getTipo() + "] " + getNombre() +
                " | Capacidad: " + getCapacidadProceso();
    }

    /**
     * Devuelve una representación en texto de la planta de proceso, incluyendo los datos
     * heredados de {@link UnidadOperativa} su capacidad
     * @return descripcion detallada de la planta de proceso.
     */
    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Capacidad: " + getCapacidadProceso() + '\n';
    }
}

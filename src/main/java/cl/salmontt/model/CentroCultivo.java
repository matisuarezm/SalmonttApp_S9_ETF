package cl.salmontt.model;

/**
 * Representa un centor de cultivo como unidad operativa, incluyendo su informacion básica como las toneladas de produccion asociadas.
 * Extiende de {@link UnidadOperativa} e implementa el contrato {@link cl.salmontt.Interfaces.Registrable} para ser mostrado de forma resumida.
 *
 * @author msuarez
 * @version 1.0
 */
public class CentroCultivo extends UnidadOperativa{

    /**
     * Toneladas de produccion asociadas al centro de cultivo
     */
    private final double toneladasProduccion;

    /**
     * Crea un nuevo centro de cultivo con sus datos básicos y la produccion de toneladas
     * @param id Identificador interno de la unidad operativa
     * @param tipo tipo de unidad (centro o planta)
     * @param nombre nombre del centro de cultivo
     * @param comuna comuna donde se encuentra el centro
     * @param toneladasProduccion cantidad de toneladas producidas por el centro
     */
    public CentroCultivo(String id, String tipo, String nombre, String comuna, double toneladasProduccion) {
        super(id, tipo, nombre, comuna);
        this.toneladasProduccion = toneladasProduccion;
    }

    /**
     * Obtiene las toneladas de produccion asociadas al centro de cultivo.
     * @return cantidad de toneladas producidas
     */
    public double getToneladasProduccion() {
        return toneladasProduccion;
    }

    /**
     * Muestra por consola el detalle completo del centro de cultivo en un formato legible para el usuario
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("=======================");
        System.out.println("   CENTRO DE CULTIVO   ");
        System.out.println("=======================");
        System.out.println(this.toString());
        System.out.println();
    }

    /**
     * {@inheritDoc}
     * En este caso, incluye el tipo, nombre y las toneladas de produccion
     * @return cadena de texto con el resumen del centro de cultivo.
     */
    @Override
    public String mostrarResumen() {
        return "[" + getTipo() + "] " + getNombre() +
                " | Toneladas: " + getToneladasProduccion();
    }

    /**
     * Devuelve una representacion en texto del centro de cultivo, incluyendo los datos heredados de {@link UnidadOperativa}
     * y las toneladas de producción.
     * @return descripcion detallada del centro de cultivo.
     */
    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Toneladas: " + getToneladasProduccion() + '\n';
    }
}

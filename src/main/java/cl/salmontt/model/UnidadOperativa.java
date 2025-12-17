package cl.salmontt.model;

import cl.salmontt.Interfaces.Registrable;

/**
 * Clase base abstracta para las unidades operativas de la empresa como {@link CentroCultivo} y {@link PlantaProceso}
 *
 * @author msuarez
 * @version 1.0
 */
public abstract class UnidadOperativa implements Registrable {

    private String id;
    private String tipo;
    private String nombre;
    private String comuna;

    /**
     * Crea una unidad operativa con sus datos basico de identificacion y ubicación.
     * @param id
     * @param tipo
     * @param nombre
     * @param comuna
     */
    public UnidadOperativa (String id,String tipo, String nombre, String comuna){
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.comuna = comuna;
    }

    /**
     * Obtiene el identificador interno de la unidad operativa.
     * @return id de la unidad
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el tipo de unidad.
     * @return tipo de unidad
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el nombre de la unidad operativa.
     * @return nombre de la unidad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la comuna donde se ubica la unidad operativa.
     * @return comuna de la unidad
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * Metodo abstracto para mostrar información detallada de las Unidades Operativas
     * cada subclase define su propio formato de presentación
     */
    public abstract void mostrarInformacion();

    /**
     * Devuelve una representacion textual basica de la unidad operativa
     * @return cadena de texto con los datos principales de la unidad
     */
    @Override
    public String toString(){
        return "ID: " + getId() + '\n' +
                "Tipo: " + getTipo() + '\n' +
                "Nombre: " + getNombre() + '\n' +
                "Comuna: " + getComuna();

    }
}

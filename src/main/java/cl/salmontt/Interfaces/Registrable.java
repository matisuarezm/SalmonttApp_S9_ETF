package cl.salmontt.Interfaces;

/**
 * Contrato que define el comportamiento basico de las entidades que pueden ser registradas y mostradas de
 * forma resumida en el sistema. Las clases que implementan esta interfaz deben entregar una representacion resumida
 * de sus datos principales. {@link cl.salmontt.model.Persona} y {@link cl.salmontt.model.UnidadOperativa} son las clases
 * padres que implementan Registrable.
 *
 * @author msuarez
 * @version 1.0
 */
public interface Registrable {

    /**
     * Realiza la operación de registro de la entidad.
     */
    void registrar();

    /**
     * Devuelve un resumen de la informacion relevante de la entidad.
     * se utiliza para mostrar el objeto en listados de manera compacta y legible.
     * @return una cadena de texto con la informacion resumida de la entidad
     */
    String mostrarResumen();

}

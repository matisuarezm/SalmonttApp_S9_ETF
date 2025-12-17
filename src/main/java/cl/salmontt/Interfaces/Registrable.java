package cl.salmontt.Interfaces;

/**
 * Contrato que define el comportamiento basico de las entidades que pueden ser registradas y mostradas de
 * forma resumida en el sistema. Las clases que implementas esta interfaz deben entregar una representacion resumida
 * de sus datos principales.
 *
 * @author msuarez
 * @version 1.0
 */
public interface Registrable {

    /**
     * Devuelve un resumen de la informacion relevante de la entidad.
     * se utiliza para mostrar el objeto en listados de manera compacta y legible.
     * @return una cadena de texto con la informacion resumida de la entidad
     */
    String mostrarResumen();

}

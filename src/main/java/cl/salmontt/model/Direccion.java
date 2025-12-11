package cl.salmontt.model;

/**
 * Clase referente a detalles de la Direccion de los clientes de la empresa Salmontt de Puerto Montt
 * (calle, número, casa o Departamento, comuna y region) esta compone la clase {@link Persona} y así
 * manejar por separado los detalles de la dirección
 *
 * @author msuarez
 * @version 1.0
 */

public class Direccion {

    //Atributos de clase
    private String direccion;
    private String comuna;
    private String region;

    /**
     * Constructor vacio sin parametros, el cual permite crear un objeto sin inicializar sus atributos
     */
    public Direccion(){}

    /**
     * Constructor con parametros
     *
     * @param direccion            nombre fisico de la ubicación del domicilio
     * @param comuna           lugar geografico donde se encuentra el domicilio dentro de la region
     * @param region           sector y ubicacion de un lugar en un pais
     */
    public Direccion(String direccion, String comuna, String region){
        this.direccion = direccion;
        this.comuna = comuna;
        this.region = region;
    }

    /**
     * Retorna el nombre de la calle
     *
     * @return calle, del tipo String
     */
    public String getDireccion(){
        return direccion;
    }

    /**
     * Retorna la comuna en donde se encuentra el domicilio dentro de la region
     *
     * @return del tipo String
     */
    public String getComuna(){
        return comuna;
    }

    /**
     * Retorna la region como complemento de la comuna
     *
     * @return del tipo String
     */
    public String getRegion(){return region;}


    /**
     * Establece la calle dentro de direccion
     *
     * @param direccion the calle
     */
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    /**
     * Establece la comuna dentro de la region
     *
     * @param comuna the comuna
     */
    public void setComuna(String comuna){
        this.comuna = comuna;
    }

    /**
     * Establece la region dentro de la direccion
     *
     * @param region the region
     */
    public void setRegion(String region){
        this.region = region;
    }

    /**
     * Es una representacion textual de la direccion física con todos sus atributos como calle, número,
     * Casa o departamento, comuna y región.
     * @return una cadena de texto con los datos de una dirección formateada.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %s", "Dirección:", direccion));
        sb.append(String.format(", %s",comuna));
        if (region != null && !region.isEmpty()) {
            sb.append(String.format(", " + region));
        }

        return sb.toString();
    }

}

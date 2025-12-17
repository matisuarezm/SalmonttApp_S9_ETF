package cl.salmontt.model;

/**
 * Representa un producto del catálogo, incluyendo su codigo, nombre, categoría y precio.
 * Se utiliza principalmente en orden de compra para calcular subtotales y totales a partir de la cantidad
 *
 * @author msuarez
 * @version 1.0
 */
public class Producto {

    private String codigo;
    private String nombre;
    private String categoria;
    private double precioUnitario;

    /**
     * Crea un producto con sus atributos correspondientes.
     * @param codigo código del producto
     * @param nombre nombre comercial del producto
     * @param categoria categoría del producto
     * @param precioUnitario debe ser mayor a 0
     * @throws IllegalArgumentException si el precio unitario es menor o igual a 0
     */
    public Producto(String codigo, String nombre, String categoria, double precioUnitario) {
        if (precioUnitario <= 0){
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioUnitario = precioUnitario;
    }

    /**
     * Obtiene el código interno del producto
     * @return código del producto
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el nombre comercial del producto
     * @return nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la categoría del producto
     * @return categoría del producto
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Obtiene el precio unitario del producto
     * @return precio unitario
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Devuelve una representacion textual del producto incluyendo codigo nombre, categoría y precio formateados
     * @return cadena de texto con la información del producto
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %s\n","Código:",codigo));
        sb.append(String.format("%-10s %s\n","Nombre:",nombre));
        sb.append(String.format("%-10s %s\n","Categoria:",categoria));
        sb.append(String.format("%-10s %s\n","Precio:",precioUnitario));

        return sb.toString();
    }
}

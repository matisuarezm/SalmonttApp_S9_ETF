package cl.salmontt.model;

public class Producto {

    private String codigo;
    private String nombre;
    private String categoria;
    private double precioUnitario;

    public Producto(String codigo, String nombre, String categoria, double precioUnitario) {
        if (precioUnitario <= 0){
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precioUnitario = precioUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %s\n","Código:",codigo));
        sb.append(String.format("%-10s %s\n","Nombre:",nombre));
        sb.append(String.format("%-10s %s\n","Categoria:",categoria));
        sb.append(String.format("%-10s %s\n","Precio:",precioUnitario));

        return sb.toString();
    }
}

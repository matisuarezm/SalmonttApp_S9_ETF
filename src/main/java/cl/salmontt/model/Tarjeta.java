package cl.salmontt.model;

/**
 * Representa una tarjeta aociada a un cliente para realizar pagos, incluye banco emisor, numero de tarjeta, tipo y fecha de vencimiento
 *
 * @author msuarez
 * @version 1.0
 */
public class Tarjeta {

    private String banco;
    private String numeroTarjeta;
    private String tipoTarjeta;
    private String fechaVencimiento;

    /**
     * Crea una tarjeta con banco, numero, tipo u fecha de vencimiento
     * @param banco nombre del banco emisor
     * @param numeroTarjeta numero completo de la tarjeta
     * @param tipo tipo de tarjeta (Crédito, Débito, Etc.)
     * @param fechaVencimiento fecha de vencimiento en formato texto
     * @throws IllegalArgumentException si el número de tarjeta es nulo o tiene menos de 4 caracteres
     */
    public Tarjeta(String banco, String numeroTarjeta, String tipo, String fechaVencimiento) {
        if (numeroTarjeta == null || numeroTarjeta.length() < 4){
            throw new IllegalArgumentException("Numero de tarjeta invalido");
        }
        this.banco = banco;
        this.numeroTarjeta = numeroTarjeta;
        this.tipoTarjeta = tipo;
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Obtiene el banco emisor de la tarjeta.
     * @return banco emisor
     */
    public String getBanco() {
        return banco;
    }

    /**
     * Obtiene el número completo de la tarjeta.
     * @return número de tarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Obtiene el tipo de tarjeta.
     * @return tipo de tarjeta
     */
    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    /**
     * Obtiene la fecha de vencimiento de la tarjeta.
     * @return fecha de vencimiento
     */
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Devuelve una representacion textual de la tarjeta
     * @return cadena de texto con la informacion formateada de la tarjeta
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        String ultimos4 = numeroTarjeta.substring(numeroTarjeta.length() - 4);
        sb.append("Pago: ").append(banco).append(" - ").append(tipoTarjeta)
                .append(" | Tarjeta: ").append(ultimos4)
                .append(" | Vencimiento: ").append(fechaVencimiento).append("\n");

        return sb.toString();
    }

}

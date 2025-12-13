package cl.salmontt.model;

public class Tarjeta {

    private String banco;
    private String numeroTarjeta;
    private String tipoTarjeta;
    private String fechaVencimiento;

    public Tarjeta(String banco, String numeroTarjeta, String tipo, String fechaVencimiento) {
        if (numeroTarjeta == null || numeroTarjeta.length() < 4){
            throw new IllegalArgumentException("Numero de tarjeta invalido");
        }
        this.banco = banco;
        this.numeroTarjeta = numeroTarjeta;
        this.tipoTarjeta = tipo;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getBanco() {
        return banco;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        String ultimos4 = numeroTarjeta.substring(numeroTarjeta.length() - 4);
        sb.append("Pago: ").append(banco).append(" - ").append(tipoTarjeta)
                .append(" | Tarjeta: ").append(ultimos4)
                .append(" | Vencimiento: ").append(fechaVencimiento).append("\n");

        /*
        sb.append(String.format("%-10s %s\n","Banco:",banco));
        sb.append(String.format("%-10s %s\n","Tipo:",tipoTarjeta));
        sb.append(String.format("%-10s %s\n","Numero:",ultimos4));
        sb.append(String.format("%-10s %s\n","F. Vencimiento:",fechaVencimiento));
         */

        return sb.toString();
    }

}

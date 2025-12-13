package cl.salmontt.model;

import cl.salmontt.Interfaces.Registrable;

public class CentroCultivo extends UnidadOperativa implements Registrable {

    private final double toneladasProduccion;

    public CentroCultivo(String id, String tipo, String nombre, String comuna, double toneladasProduccion) {
        super(id, tipo, nombre, comuna);
        this.toneladasProduccion = toneladasProduccion;
    }

    public double getToneladasProduccion() {
        return toneladasProduccion;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("=======================");
        System.out.println("   CENTRO DE CULTIVO   ");
        System.out.println("=======================");
        System.out.println(this.toString());
        System.out.println();
    }

    @Override
    public String mostrarResumen() {
        return "[" + getTipo() + "] " + getNombre() +
                " | Toneladas: " + getToneladasProduccion();
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Toneladas: " + getToneladasProduccion();
    }
}

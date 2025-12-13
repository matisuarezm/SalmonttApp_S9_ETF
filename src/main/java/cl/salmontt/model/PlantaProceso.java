package cl.salmontt.model;

import cl.salmontt.Interfaces.Registrable;

public class PlantaProceso extends UnidadOperativa implements Registrable {

    private final double capacidadProceso;

    public PlantaProceso(String id, String tipo, String nombre, String comuna, double capacidadProceso) {
        super(id, tipo, nombre, comuna);
        this.capacidadProceso = capacidadProceso;
    }

    public double getCapacidadProceso(){
        return capacidadProceso;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("***********************");
        System.out.println("   PLANTA DE PROCESO   ");
        System.out.println("***********************");
        System.out.println(this.toString());
        System.out.println();
    }

    @Override
    public String mostrarResumen() {
        return "[" + getTipo() + "] " + getNombre() +
                " | Capacidad: " + getCapacidadProceso();
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Capacidad: " + getCapacidadProceso();
    }
}

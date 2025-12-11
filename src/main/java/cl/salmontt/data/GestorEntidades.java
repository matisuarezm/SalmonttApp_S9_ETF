package cl.salmontt.data;

import cl.salmontt.model.*;
import cl.salmontt.util.ValidaRutException;

import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {

    private List<Registrable> registros;

    public GestorEntidades(){
        this.registros = new ArrayList<>();
    }

    public void CargarRegistrosPrueba() throws ValidaRutException {

        registros.add(new CentroCultivo("C0200","Centro","Salmontt Valdivia","Valdivia",80.0));
        registros.add(new CentroCultivo("C0300","Centro","Salmontt Coyhaique","Coyhaique",50.0));

        registros.add(new PlantaProceso("P1001","Planta","Salmontt La Calera","La Calera",120.00));
        registros.add(new PlantaProceso("P2001","Planta","Salmontt Los Vilos","Los Vilos",30.50));

        registros.add(new Empleado("Matias Suarez", "17404347-7", "Nuñez de Balboa #1123, Casa 07",
                "Santiago", "RM", "+56965995289", "20-01-2020", "Encargado TI","Informatica", "msuarez@salmontt.cl", 1200000));
        registros.add(new Empleado("Victoria Suarez", "26680048-7", "Avenida Concepción #1123", "Santiago" ,
                "RM", "5695040666", "20-01-2020", "Administrativo", "Informatica", "victoria@salmontt.cl", 1500000));

        registros.add(new Proveedor("GLS Exports", "77772750-8","Monseñor Sotero Sanz #55, Of. 700","Providencia", "RM"
                , "Exportadora", "+56224994400","gls@gls.cl"));
        registros.add(new Proveedor("JyA International", "96688670-6","Camino la Vilana #12500","Lampa", "RM"
                , "Venta de Insumos Menores", "+56228445152","contacto@jya.cl"));

    }

    public List<Registrable> getRegistros(){
        return registros;
    }

    public void agregarRegistro (Registrable reg){
        registros.add(reg);
        System.out.println(reg.toString());
    }

    public void visualizarRegistro(){
        for (Registrable reg : registros){
            if (reg instanceof CentroCultivo centroCultivo){
                System.out.println("Es un Centro: " + centroCultivo.getNombre());
            } else if (reg instanceof PlantaProceso plantaProceso) {
                System.out.println("Es una Planta: " + plantaProceso.getNombre());
            }else if (reg instanceof Proveedor proveedor){
                System.out.println("Proveedor: " + proveedor.getNombre());
            } else if (reg instanceof Empleado empleado) {
                System.out.println("Empleado: " + empleado.getNombre());
            }

        }
    }

    public String listarTodos(){
        String informacion = "";

        for (Registrable reg : registros){
            informacion += reg.mostrarResumen() + '\n';
        }
        return informacion;
    }

}

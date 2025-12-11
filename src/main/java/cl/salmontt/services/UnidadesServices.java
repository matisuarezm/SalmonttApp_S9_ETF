package cl.salmontt.services;

import cl.salmontt.model.CentroCultivo;
import cl.salmontt.model.PlantaProceso;
import cl.salmontt.model.UnidadOperativa;

import java.util.ArrayList;
import java.util.List;

public class UnidadesServices {

    //Mostramos todas las Unidades Operativas
    public void listarTodos(List<UnidadOperativa> unidadOperativas){
        for (UnidadOperativa unidades : unidadOperativas){
            unidades.mostrarInformacion();
        }
    }

    //Mostramos la información de las plantas de proceso
    public void mostrarPlantasProceso(List<UnidadOperativa> unidadOperativas){
        for (UnidadOperativa unidades : unidadOperativas){
            if (unidades instanceof PlantaProceso){
                unidades.mostrarInformacion();
            }
        }
    }

    //Mostramos información de los centros de cultivo
    public void mostrarCentrosCultivos(List<UnidadOperativa> unidadOperativas){
        for (UnidadOperativa unidades : unidadOperativas){
            if (unidades instanceof CentroCultivo){
                unidades.mostrarInformacion();
            }
        }
    }

    //Separamos las Plantas de proceso en una nueva lista llamada resultadoPlantas
    public List<PlantaProceso> obtenerPlantasProceso(List<UnidadOperativa> unidadOperativas){
        List<PlantaProceso> resultadoPlantas = new ArrayList<>();
        for (UnidadOperativa unidades : unidadOperativas) {
            if (unidades instanceof PlantaProceso) {
                resultadoPlantas.add((PlantaProceso) unidades);
            }
        }
        return resultadoPlantas;
    }

    //Separamos los centros de cultivo en una nueva lista llamada resultadoCentros
    public List<CentroCultivo> obtenerCentrosCultivos(List<UnidadOperativa> unidadOperativas){
        List<CentroCultivo> resultadoCentros = new ArrayList<>();
        for (UnidadOperativa unidades : unidadOperativas) {
            if (unidades instanceof CentroCultivo) {
                resultadoCentros.add((CentroCultivo) unidades);
            }
        }
        return resultadoCentros;
    }

}

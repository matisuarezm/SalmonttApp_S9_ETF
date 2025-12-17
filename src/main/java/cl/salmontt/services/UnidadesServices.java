package cl.salmontt.services;

import cl.salmontt.model.CentroCultivo;
import cl.salmontt.model.PlantaProceso;
import cl.salmontt.model.UnidadOperativa;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de negocio para operar sobre las unidades operativas del sistema,
 * permitiendo listarlas y filtrarlas por tipo (planta de proceso o centro de cultivo).
 * @author msuarez
 * @version 1.0
 */
public class UnidadesServices {

    /**
     * Muestra por consola la información detallada de todas las unidades operativas.
     * Cada unidad utiliza su propia implementación de {@link UnidadOperativa#mostrarInformacion()}.
     * @param unidadOperativas
     */
    public void listarTodos(List<UnidadOperativa> unidadOperativas){
        for (UnidadOperativa unidades : unidadOperativas){
            unidades.mostrarInformacion();
        }
    }

    /**
     * Muestra por consola solo las plantas de proceso contenidas en la lista,
     * utilizando {@code instanceof} para filtrar por tipo concreto.
     * @param unidadOperativas lista de unidades operativas a filtrar
     */
    public void mostrarPlantasProceso(List<UnidadOperativa> unidadOperativas){
        for (UnidadOperativa unidades : unidadOperativas){
            if (unidades instanceof PlantaProceso){
                unidades.mostrarInformacion();
            }
        }
    }

    /**
     * Muestra por consola solo los centros de cultivo contenidos en la lista,
     * utilizando {@code instanceof} para filtrar por tipo concreto.
     * @param unidadOperativas lista de unidades operativas a filtrar
     */
    public void mostrarCentrosCultivos(List<UnidadOperativa> unidadOperativas){
        for (UnidadOperativa unidades : unidadOperativas){
            if (unidades instanceof CentroCultivo){
                unidades.mostrarInformacion();
            }
        }
    }

    /**
     * Obtiene una lista con solo las plantas de proceso a partir de la lista general de unidades operativas.
     * @param unidadOperativas lista general de unidades operativas
     * @return nueva lista que contiene únicamente instancias de {@link PlantaProceso}
     */
    public List<PlantaProceso> obtenerPlantasProceso(List<UnidadOperativa> unidadOperativas){
        List<PlantaProceso> resultadoPlantas = new ArrayList<>();
        for (UnidadOperativa unidades : unidadOperativas) {
            if (unidades instanceof PlantaProceso) {
                resultadoPlantas.add((PlantaProceso) unidades);
            }
        }
        return resultadoPlantas;
    }

    /**
     * Obtiene una lista con solo los centros de cultivo a partir de la lista general de unidades operativas.
     * @param unidadOperativas lista general de unidades operativas
     * @return nueva lista que contiene únicamente instancias de {@link CentroCultivo}
     */
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

package cl.salmontt.ui;

import cl.salmontt.data.GestorEntidades;
import cl.salmontt.data.GestorUnidades;
import cl.salmontt.model.CentroCultivo;
import cl.salmontt.model.PlantaProceso;
import cl.salmontt.model.Registrable;
import cl.salmontt.model.UnidadOperativa;
import cl.salmontt.services.UnidadesServices;
import cl.salmontt.util.UtilidadConsola;
import cl.salmontt.util.ValidaRutException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Inciando SalmonttAPP");
        SalmonttAppFrame ventana = new SalmonttAppFrame();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);

    }
}
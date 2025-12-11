package cl.salmontt.data;

import cl.salmontt.model.CentroCultivo;
import cl.salmontt.model.PlantaProceso;
import cl.salmontt.model.UnidadOperativa;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GestorUnidades {

    //Cargas manuales de objetos para UnidadesOperativas (Centros y Plantas de cultivo)
    public List<UnidadOperativa> pruebasManuales(){

        List<UnidadOperativa> unidades = new ArrayList<>();

        unidades.add(new CentroCultivo("C0100","centro","Salmontt Coquimbo","Coquimbo",60.0));
        unidades.add(new CentroCultivo("C0200","centro","Salmontt Valdivia","Valdivia",80.0));
        unidades.add(new CentroCultivo("C0300","centro","Salmontt Coyhaique","Coyhaique",50.0));

        unidades.add(new PlantaProceso("P1001","planta","Salmontt La Calera","La Calera",120.00));
        unidades.add(new PlantaProceso("P2001","planta","Salmontt Los Vilos","Los Vilos",30.50));
        unidades.add(new PlantaProceso("P3001","planta","Salmontt Concepción","Concepción",250.00));

        return unidades;
    }

    //Cargamos el archivo desde un txt y recibimos el nombre del archivo, siempre que este dentro de la carpeta resources
    public List<UnidadOperativa> cargaDesdeTxt (String nombreArchivo){

        //Creamos ArrayList de objetos de la clase UnidadesOperativas para guardar los datos del archivo.
        List<UnidadOperativa> registroUnidades = new ArrayList<>();

        //Busqueda de recursos dentro del classpath
        //ClassLoader -> objeto que sabe buscar clases y recursos en el classpath
        //classpath -> es el conjunto de lugares donde Java mira para encontrar clases y recursos cuando corre tu programa.
        ClassLoader classLoader = getClass().getClassLoader();

        try {
            //Utiliza el archivo entregado que busca dentro de la carpeta resources
            //InputStream -> crea un objeto que sabe leer ese archivo como un flujo de bytes y te lo devuelve en la variable lecturaArchivo (tipo InputStream).
            InputStream lecturaArchivo = classLoader.getResourceAsStream(nombreArchivo);

            //Si archivo TXT no se encuentra arrojamos mensaje
            if (lecturaArchivo == null){
                System.err.println("No se encontró el archivo " + nombreArchivo);
                return registroUnidades;
            }

            //Abrimos el archivo con BufferReader
            //InputStreamReader -> convierte los bytes del InputStream en caracteres usando una codificación (UTF-8, etc.).
            //BufferedReader -> te da métodos como readLine() para leer cada línea.
            try (BufferedReader br = new BufferedReader(new InputStreamReader(lecturaArchivo))){

                //Variable para almacenar cada línea que se lee del archivo
                String lineaArchivo;
                //contador de las líneas leídas (en caso de error podemos arrojar un mensaje más exacto)
                int numeroLinea = 0;

                //leemos el archivo línea a línea hasta que readLine() devuelve null
                while ((lineaArchivo = br.readLine()) != null){
                    numeroLinea++;

                    //si la línea está vacía o solo tiene espacios se salta a la siguiente
                    if (lineaArchivo.trim().isEmpty()){
                        continue;
                    }

                    //Separamos la línea usando ';' y cada parte la guardamos en un arreglo
                    String [] fila = lineaArchivo.split(";");

                    //Verificamos que el arreglo tenga 5 elementos (formato requerido)
                    if (fila.length != 5){
                        System.err.println("La Linea " + numeroLinea + " no tiene el formato esperado o es invalida");
                        continue;
                    }

                    //signamos los datos del archivo según corresponde a su atributo
                    String id = fila[0].trim();
                    String tipo = fila[1].trim();
                    String nombre = fila[2].trim();
                    String comuna = fila[3].trim();
                    String cantidadStr = fila[4].trim();

                    //Convertimos la cantidad a número y depende del tipo, creamos el objeto correspondiente
                    try {
                        double cantidad = Double.parseDouble(cantidadStr);

                        if (tipo.equalsIgnoreCase("centro")){
                            registroUnidades.add(new CentroCultivo(id,tipo,nombre,comuna,cantidad));

                        }else if (tipo.equalsIgnoreCase("planta")){
                            registroUnidades.add(new PlantaProceso(id,tipo,nombre,comuna,cantidad));
                        }else {
                            System.err.println("Tipo desconocido en la linea " + numeroLinea + ": " + tipo);
                        }

                    }catch (NumberFormatException exception){
                        //Mensaje en caso de que la cantidad no se pueda convertir en numero
                        System.err.println("La cantidad de la linea " + lineaArchivo + " no corresponden a un número");
                    }
                }
            }
        }catch (Exception ex){
            //Capturamos cualquier error general en la lectura del archivo
            System.err.println("Ocurrió un error en la lectura del archivo");
        }
        return registroUnidades;
    }
}

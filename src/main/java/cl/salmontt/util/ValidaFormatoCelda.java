package cl.salmontt.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase validadora sobre los datos obtenidos desde un archivo Excel
 *
 * @author msuarez
 * @version 1.0
 */

public class ValidaFormatoCelda {

    /**
     * Valida que informacion ingresada sea un texto
     * @param celda captura la información ingresada en la celda
     * @return valor en formato texto
     */
    public static String validarString(Cell celda){
        if (celda == null) return "";
        switch (celda.getCellType()) {
            case STRING: return celda.getStringCellValue();
            case NUMERIC: return String.valueOf(celda.getNumericCellValue());
            case BOOLEAN: return String.valueOf(celda.getBooleanCellValue());
            default: return "";
        }
    }

    /**
     * Valida que información ingresada sea un numero entero
     * @param celda captura la información ingresada en la celda
     * @return valor entero
     */
    public static int validarInt(Cell celda){
        if (celda == null) return 0;
        switch (celda.getCellType()){
            case NUMERIC: return (int) celda.getNumericCellValue();
            case STRING:
                try {
                    return Integer.parseInt(celda.getStringCellValue());
                }catch (NumberFormatException e){
                    System.out.println("Error al convertir celda a número entero: " + celda.getStringCellValue());
                    return 0;
                }
            default: return 0;
        }
    }

    /**
     * Valida que información ingresada sea un numero decimal
     * @param celda captura la información ingresada en la celda
     * @return valor decimal
     */
    public static double validarDouble(Cell celda){
        if (celda == null) return 0;
        switch (celda.getCellType()){
            case NUMERIC: return celda.getNumericCellValue();
            case STRING:
                try{
                    return Double.parseDouble(celda.getStringCellValue());
                }catch (NumberFormatException e){
                    System.out.println("Error al convertir celda en número decimal" + celda.getStringCellValue());
                    return 0;
                }
            default: return 0;
        }
    }

    /**
     * Valida que información ingresada sea de formato fecha
     * @param celda captura la información ingresada en la celda
     * @return una fecha
     */
    public static Date validarFecha(Cell celda){
        if (celda == null) return null;
        if (celda.getCellType() == CellType.STRING){
            String texto = celda.getStringCellValue();
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
            try{
                return formato.parse(celda.getStringCellValue());
            }catch (Exception e){
                System.out.println("Fecha inválida " + texto);
                return null;
            }
        }
        if (celda.getCellType() == CellType.NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(celda)){
            return celda.getDateCellValue();
        }
        if (celda.getCellType() == CellType.NUMERIC){
            org.apache.poi.ss.usermodel.DateUtil.getJavaDate(celda.getNumericCellValue());
        }
        return null;
    }
    /**
     * Permite darle un formato a la fecha
     * @param celda captura la información ingresada en la celda
     * @return una fecha
     */
    public static String validarFechaString(Cell celda, String patron){
        Date fecha = validarFecha(celda);
        if (fecha == null) return "";
        SimpleDateFormat formato = new SimpleDateFormat(patron);
        return formato.format(fecha);
    }
}
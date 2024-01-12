package ManejoArchivos;

import java.io.File;

/**
 * Clase Ejemplo5, uso de las calses File para borrar archivos en Java
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Ejemplo5 {
    public static void main(String[] args) {
        File archivo = new File("prueba.txt");
        if (archivo.delete()) {
            System.out.println("Archivo borrado: " + archivo.getName());
        } else {
            System.out.println("No se pudo borrar el archivo.");
        }
    }
}

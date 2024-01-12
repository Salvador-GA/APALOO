package ManejoArchivos;

import java.io.File;
import java.io.IOException;

/**
 * Clase Ejemplo4, uso de las calses File para crear archivos en Java
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Ejemplo4 {
    public static void main(String[] args) {
        try {
            File archivo = new File("prueba.txt");
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

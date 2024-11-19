package ManejoArchivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Clase Ejemplo8, uso de las calses File y FileInputStream para leer archivos
 * completos en bytes de una sola vez en Java
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Ejemplo8 {
    public static void main(String[] args) {
        File archivo = new File("./src/ManejoArchivos/img.jpg");
        FileInputStream fr = null;

        try {
            fr = new FileInputStream(archivo);
            byte[] bytes = new byte[(int) archivo.length()];
            fr.read(bytes);
            System.out.println("Bytes del archivo:");
            for (byte b : bytes) {
                System.out.print(String.format("%02X ", b)); // Muestra en formato hexadecimal
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

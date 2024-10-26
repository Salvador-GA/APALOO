import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase Ejemplo7, uso de las calses File y FileReader para leer archivos
 * completos de una sola vez en Java
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Ejemplo7 {
    public static void main(String[] args) {
        File archivo = new File("./src/ManejoArchivos/Ejemplo.txt");
        FileReader fr = null;

        try {
            fr = new FileReader(archivo);
            char[] chars = new char[(int) archivo.length()];
            fr.read(chars);
            String contenido = new String(chars);
            System.out.println(contenido);
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

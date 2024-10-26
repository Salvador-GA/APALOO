import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Clase Ejemplo2, uso de las calses File, FileReader y BufferedReader para leer
 * el contenido de archivos en Java
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Ejemplo2 {
    public static void main(String[] arg) {
        File archivo = null;
        FileReader reader = null;
        BufferedReader buffer = null;
        try {
            archivo = new File("./src/ManejoArchivos/Ejemplo.txt");
            reader = new FileReader(archivo);
            buffer = new BufferedReader(reader);
            String linea;
            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader) {
                    reader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}

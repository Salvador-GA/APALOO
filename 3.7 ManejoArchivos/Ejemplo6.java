import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase Ejemplo6, uso de las calses File y FileReader para leer archivos
 * caracter a caracter en Java
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Ejemplo6 {
    public static void main(String[] args) {
        File archivo = new File("./src/ManejoArchivos/Ejemplo.txt");
        FileReader fr = null;

        try {
            fr = new FileReader(archivo);
            int caracter;
            while ((caracter = fr.read()) != -1) {
                System.out.print((char) caracter);
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

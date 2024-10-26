import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Clase Ejemplo3, uso de las calses File, FileWriter y PrintWriter para
 * escribir contenido en archivos en Java
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Ejemplo3 {
    public static void main(String[] args) {
        File archivo = null;
        FileWriter writer = null;
        PrintWriter pw = null;
        try {
            archivo = new File("./src/ManejoArchivos/Ejemplo.txt");
            writer = new FileWriter(archivo, true);
            pw = new PrintWriter(writer);
            pw.println("");
            for (int i = 0; i < 10; i++) {
                pw.println("Linea " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != writer) {
                    writer.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

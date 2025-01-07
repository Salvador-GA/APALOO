import java.util.Random;

/**
 * Clase Principal, hace uso de las clases OrdenamientoRecursivo,
 * BusquedaRecursiva y TorresHanoi para verificar su correcto funcionamiento
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
public class Principal {
    public static void main(String[] args) {
        int M = 20;
        int[] arreglo = new int[M];
        Random rnd = new Random();

        System.out.println("Ordenamiento recursivo");
        for (int i = 0; i < M; i++) {
            arreglo[i] = rnd.nextInt(20);
            System.out.print(" " + arreglo[i]);
        }
        OrdenamientoRecursivo.quicksort(arreglo, 0, M - 1);
        System.out.println();
        for (int i = 0; i < M; i++) {
            System.out.print(" " + arreglo[i]);
        }
        System.out.println();

        System.out.println("\nBusqueda recursiva");
        System.out.println("El número 10 se encuentra en: " + BusquedaRecursiva.busquedaBinaria(arreglo, 10, 0, M - 1));

        System.out.println("\nTorres de Hanoi");
        TorresHanoi.resolverHanoi(4, "inicial", "auxiliar", "final");
    }
}

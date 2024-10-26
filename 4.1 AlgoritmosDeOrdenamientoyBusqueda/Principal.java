import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        int M = 20;
        int[] arreglo = new int[M];
        Random rnd = new Random();

        for (int i = 0; i < M; i++) {
            arreglo[i] = rnd.nextInt(20);
            System.out.print(" " + arreglo[i]);
        }
        AlgoritmosOrdenamiento.burbuja(arreglo);
        System.out.println();
        for (int i = 0; i < M; i++) {
            System.out.print(" " + arreglo[i]);
        }
        System.out.println();
        System.out.println("El número 10 se encuentra en: " + AlgoritmosBusqueda.busquedaBinaria(arreglo, 10));
    }
}

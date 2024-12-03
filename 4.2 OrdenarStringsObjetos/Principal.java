import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        int M = 10;
        String[] arregloStr = new String[M];
        Random rnd = new Random();
        
        System.out.println("Prueba con String");
        // Lista de palabras para llenar el arreglo
        String[] palabras = {"manzana", "pera", "uva", "platano", "melon", 
                             "cereza", "limon", "kiwi", "durazno", "fresa", 
                             "naranja", "sandia", "papaya", "piña", "coco"};

        // Llenar el arreglo con palabras aleatorias de la lista
        for (int i = 0; i < M; i++) {
            arregloStr[i] = palabras[rnd.nextInt(palabras.length)];
            System.out.print(" " + arregloStr[i]);
        }
        // Ordenar el arreglo (modificar burbuja2 para soportar String[])
        AlgoritmosOrdenamiento.burbujaString(arregloStr);
        System.out.println();
        // Mostrar el arreglo ordenado
        for (int i = 0; i < M; i++) {
            System.out.print(" " + arregloStr[i]);
        }
        System.out.println();

        System.out.println("\nPrueba con personas");
        Persona[] arregloPersona = new Persona[M];

        // Nombres y apellidos de ejemplo
        String[] nombres = {"Juan", "Ana", "Luis", "María", "Pedro", "Elena", "Carlos", "Sofía", "Lucía", "Miguel"};
        String[] apellidos = {"Pérez", "García", "López", "Rodríguez", "Martínez", "Hernández", "González", "Díaz", "Torres", "Ramírez"};

        // Llenar el arreglo con personas aleatorias
        for (int i = 0; i < M; i++) {
            int id = rnd.nextInt(100); // ID aleatorio entre 0 y 99
            String nombre = nombres[rnd.nextInt(nombres.length)];
            String apellido = apellidos[rnd.nextInt(apellidos.length)];
            int edad = 18 + rnd.nextInt(50); // Edad entre 18 y 67
            arregloPersona[i] = new Persona(id, nombre, apellido, edad);
        }

        // Mostrar el arreglo antes de ordenar
        System.out.println("Antes de ordenar:");
        for (Persona p : arregloPersona) {
            System.out.println(p);
        }

        // Ordenar el arreglo usando burbuja
        AlgoritmosOrdenamiento.burbujaPersona(arregloPersona);

        // Mostrar el arreglo después de ordenar
        System.out.println("\nDespués de ordenar:");
        for (Persona p : arregloPersona) {
            System.out.println(p);
        }
    }
}

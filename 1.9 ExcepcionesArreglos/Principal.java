public class Principal {

    public static void main(String[] args) {
        // ------------------------------
        // Ejemplo 1: Arreglo de enteros
        // ------------------------------
        System.out.println("\nEjemplo de arreglo int");
        int[] arregloInt = {1, 2, 3, 4, 5, 6};
        System.out.println("Tamaño del arreglo: " + arregloInt.length);

        int i = 8; // forzamos un índice fuera de rango (0..5)
        try {
            System.out.println("Accedemos al indice i = " + i + ": " + arregloInt[i]);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Error: Indice fuera de los limites del arreglo.");
        }

        // ---------------------------------------------------
        // Ejemplo 2: Arreglo de cadenas (fuera del ciclo)
        // Un try-catch que envuelve el for completo
        // ---------------------------------------------------
        System.out.println("\nEjemplo de arreglo String fuera del ciclo");
        String[] arregloString = {"Hola", "mundo", "uno", "Java", "ejemplo", null};
        i = 3; // intentaremos acceder al caracter en la posición i

        try {
            for (String cadena : arregloString) {
                // Posibles errores:
                // - s == null -> NullPointerException
                // - i fuera de rango para s -> StringIndexOutOfBoundsException
                System.out.println(cadena.charAt(i));
            }
        } catch (NullPointerException npe) {
            System.out.println("cadena null");
        } catch (StringIndexOutOfBoundsException sioobe) {
            System.out.println("índice fuera de rango para la cadena");
        }

        // ---------------------------------------------------
        // Ejemplo 3: Arreglo de cadenas (dentro del ciclo)
        // Un try-catch individual para cada elemento
        // ---------------------------------------------------
        System.out.println("\nEjemplo de arreglo String dentro del ciclo");
        for (String cadena : arregloString) {
            try {
                System.out.println(cadena.charAt(i));
            } catch (NullPointerException npe) {
                System.out.println("cadena null");
            } catch (StringIndexOutOfBoundsException sioobe) {
                System.out.println("índice fuera de rango para la cadena");
            }
        }
    }
}

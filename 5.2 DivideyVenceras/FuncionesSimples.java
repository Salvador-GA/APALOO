package DivideyVenceras;

/**
 * @brief Clase que implementa funciones recursivas simples sobre arreglos.
 * 
 * Contiene métodos para sumar los elementos de un arreglo y para encontrar el valor máximo,
 * utilizando el enfoque de divide y vencerás.
 */
public class FuncionesSimples {

    /**
     * @brief Suma los elementos de un arreglo de forma recursiva usando divide y vencerás.
     * 
     * Divide el arreglo en mitades y suma recursivamente cada parte hasta llegar a un solo elemento.
     * 
     * @param arreglo El arreglo de enteros a sumar.
     * @param inicio Índice de inicio del rango a sumar.
     * @param fin Índice final del rango a sumar.
     * @return La suma de los elementos desde arreglo[inicio] hasta arreglo[fin].
     */
    public static int sumarArreglo(int[] arreglo, int inicio, int fin) {
        // Caso base: solo un elemento
        if (inicio == fin) {
            return arreglo[inicio];
        } else {
            // Dividir el rango a la mitad
            int medio = (inicio + fin) / 2;
            // Sumar ambas mitades recursivamente
            return sumarArreglo(arreglo, inicio, medio) + sumarArreglo(arreglo, medio + 1, fin);
        }
    }

    /**
     * @brief Encuentra el valor máximo en un arreglo de forma recursiva.
     * 
     * Utiliza el enfoque de divide y vencerás para comparar los máximos de cada mitad del arreglo.
     * 
     * @param arreglo El arreglo de enteros del cual se desea obtener el máximo.
     * @param inicio Índice de inicio del rango a evaluar.
     * @param fin Índice final del rango a evaluar.
     * @return El valor máximo encontrado entre arreglo[inicio] y arreglo[fin].
     */
    public static int max(int[] arreglo, int inicio, int fin) {
        // Caso base: solo un elemento
        if (inicio == fin) {
            return arreglo[inicio];
        } else {
            // Dividir el rango a la mitad
            int medio = (inicio + fin) / 2;
            // Obtener el máximo de ambas mitades
            int maxIzq = max(arreglo, inicio, medio);
            int maxDer = max(arreglo, medio + 1, fin);
            // Devolver el mayor de los dos
            return (maxIzq > maxDer) ? maxIzq : maxDer;
        }
    }

}

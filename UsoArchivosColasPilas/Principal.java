package UsoArchivosColaPila;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @file Principal.java
 * @brief Programa que lee palabras desde un archivo de texto y determina si son palíndromos,
 *        usando una pila y una cola implementadas manualmente.
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {

    /**
     * Verifica si una palabra es un palíndromo utilizando una pila y una cola.
     * 
     * @param palabra La palabra a evaluar.
     * @return true si la palabra es un palíndromo, false en caso contrario.
     */
    public static boolean esPalindromo(String palabra) {
        PilaEnlazadaSimple pila = new PilaEnlazadaSimple();
        ColaEnlazadaSimple cola = new ColaEnlazadaSimple();
        char caracter;

        // Insertar cada carácter en la pila y la cola
        for (int i = 0; i < palabra.length(); i++) {
            caracter = palabra.charAt(i);
            pila.apilar(caracter);
            cola.encolar(caracter);
        }

        // Comparar elementos desde ambos extremos
        while (!pila.esVacia() && !cola.esVacia()) {
            char c1 = pila.frente();
            pila.desapilar();
            char c2 = cola.frente();
            cola.desencolar();
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

    /**
     * Método principal que lee palabras desde un archivo y muestra si son palíndromos.
     * 
     * El archivo debe ubicarse en la ruta: ./src/UsoArchivosColaPila/Ejemplo.txt
     * Cada línea debe contener una sola palabra.
     * 
     * @param arg Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] arg) {
        File archivo = null;
        FileReader reader = null;
        BufferedReader buffer = null;

        try {
            archivo = new File("./src/UsoArchivosColaPila/Ejemplo.txt");
            reader = new FileReader(archivo);
            buffer = new BufferedReader(reader);
            String palabra;

            // Leer línea por línea y verificar si es palíndromo
            while ((palabra = buffer.readLine()) != null) {
                if (esPalindromo(palabra)) {
                    System.out.println("La palabra \"" + palabra + "\" es un palíndromo.");
                } else {
                    System.out.println("La palabra \"" + palabra + "\" no es un palíndromo.");
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}

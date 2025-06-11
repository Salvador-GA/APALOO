/**
 * @file Principal.java
 * @brief Clase principal que solicita datos al usuario y ejecuta la división.
 * @author Salvador Gonalez Arerllano
 */

import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * @class Principal
 * @brief Contiene el método main para interactuar con el usuario y probar la clase Division.
 */
public class Principal {
    /**
     * @brief Método principal que pide números al usuario e intenta dividirlos.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        InputStreamReader inputstr = new InputStreamReader(System.in);
        BufferedReader buferrd = new BufferedReader(inputstr);
        double dividendo = 1;
        double divisor = 1;
        boolean exito = false;

        do {
            try {
                System.out.print("Ingrese el dividendo: ");
                dividendo = Double.parseDouble(buferrd.readLine());
                System.out.print("Ingrese divisor: ");
                divisor = Double.parseDouble(buferrd.readLine());
            } catch( Exception e) {
                System.out.println("Error al leer del teclado: " + e.getMessage());
            }

            Division div = new Division(dividendo, divisor);

            try {
                double resultado = div.dividir();
                System.out.println("Resultado: " + resultado);
                exito = true;
            } catch (myException e) {
                System.out.println("Excepción: " + e.getMessage());
                exito = false;
            }
        } while (!exito);
    }
}

/**
 * @file Principal.java
 * @brief Clase principal para ejecutar el ejemplo de Empleado y Programador.
 */

package EjemploClaseDerivada;

public class Principal {

    public static void main(String[] args) {
        // Crear una instancia de Programador
        Programador programador = new Programador("Alice", 28, 20000, "Java");

        // Mostrar información del programador
        System.out.println(programador.mostrarInformacion());
    }
}

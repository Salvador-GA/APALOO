/**
 * @file Programador.java
 * @brief Clase derivada que representa a un programador, que hereda de la clase Empleado.
 */

package EjemploClaseDerivada;

/**
 * Clase derivada Programador que extiende la clase Empleado, agregando la
 * especialización.
 */
public class Programador extends Empleado {
    private String lenguaje;

    /**
     * Constructor de la clase Programador.
     * 
     * @param nombre   Nombre del programador.
     * @param edad     Edad del programador.
     * @param salario  Salario base del programador.
     * @param lenguaje Lenguaje de programación principal del programador.
     */
    public Programador(String nombre, int edad, double salario, String lenguaje) {
        super(nombre, edad, salario); // Llama al constructor de la clase base
        this.lenguaje = lenguaje;
    }

    /**
     * Obtiene el lenguaje de programación del programador.
     * 
     * @return Lenguaje de programación del programador.
     */
    public String getLenguaje() {
        return lenguaje;
    }

    /**
     * Establece el lenguaje de programación del programador.
     * 
     * @param lenguaje Lenguaje de programación del programador.
     */
    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    /**
     * Sobrescribe el método mostrarInformacion() para agregar detalles específicos
     * del programador.
     * 
     * @return Cadena con la información del programador.
     */
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + ", Lenguaje de Programación: " + lenguaje;
    }
}

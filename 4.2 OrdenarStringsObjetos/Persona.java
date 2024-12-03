/**
 * Representa a una persona con atributos básicos como ID, nombre, apellidos y
 * edad.
 *
 * Implementa la interfaz Comparable para permitir la comparación de objetos
 * Persona.
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Persona implements Comparable<Persona> {

    private int id;
    /** < Identificador de la persona. */
    private String nombre;
    /** < Nombre de la persona. */
    private String apellidos;
    /** < Apellidos de la persona. */
    private int edad;

    /** < Edad de la persona. */

    /**
     * @brief Constructor de la clase Persona.
     * 
     * @param id        El identificador de la persona.
     * @param nombre    El nombre de la persona.
     * @param apellidos Los apellidos de la persona.
     * @param edad      La edad de la persona.
     */
    public Persona(int id, String nombre, String apellidos, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    /**
     * @brief Obtiene el ID de la persona.
     * @return El identificador único de la persona.
     */
    public int getId() {
        return id;
    }

    /**
     * @brief Obtiene el nombre de la persona.
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @brief Obtiene los apellidos de la persona.
     * @return Los apellidos de la persona.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @brief Obtiene la edad de la persona.
     * @return La edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @brief Devuelve una representación textual de la persona.
     * 
     * @return Una cadena que contiene los valores de los atributos de la persona.
     */
    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                '}';
    }

    /**
     * @brief Compara esta persona con otra según un criterio definido (por defecto,
     *        nombre).
     * 
     * @param otra La otra persona con la que se comparará.
     * @return Un valor negativo si esta persona es menor, cero si son iguales,
     *         o un valor positivo si esta persona es mayor.
     * 
     * @note Actualmente, compara los nombres de las personas. Para comparar por ID,
     *       descomenta la línea correspondiente.
     */
    @Override
    public int compareTo(Persona otra) {
        return this.nombre.compareTo(otra.nombre);
        // return Integer.compare(this.id, otra.id);
    }
}

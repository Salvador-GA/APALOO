/**
 * @file Empleado.java
 * @brief Clase base que representa a un empleado en una empresa.
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */

/**
 * Clase base Empleado que contiene los atributos y métodos comunes a todos los
 * empleados.
 */
public class Empleado {
    private String nombre;
    private int edad;
    private double salario;

    /**
     * Constructor de la clase Empleado.
     * 
     * @param nombre  Nombre del empleado.
     * @param edad    Edad del empleado.
     * @param salario Salario base del empleado.
     */
    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    /**
     * Obtiene el nombre del empleado.
     * 
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     * 
     * @param nombre El nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad del empleado.
     * 
     * @return La edad del empleado.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del empleado.
     * 
     * @param edad La edad del empleado.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el salario del empleado.
     * 
     * @return El salario del empleado.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Establece el salario del empleado.
     * 
     * @param salario El salario del empleado.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Método para devolver la información del empleado.
     * 
     * @return Cadena con la información del empleado.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Salario: " + salario;
    }

    @Override
    public boolean equals(Object otro) {
        if(this == otro){
            return true;
        } else if (otro == null || this.getClass() != otro.getClass()){
            return false;
        } else {
            Empleado emp = (Empleado) otro;
            return this.nombre.equals(emp.getNombre());
        }
    }
}

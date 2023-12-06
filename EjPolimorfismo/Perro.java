package EjPolimorfismo;

/**
 * Clase derivada Perro, extiende de la clase Animal
 * 
 * @author Salvado Gonzalez Arellano
 * @version 1.0
 */
public class Perro extends Animal {

    /**
     * metodo hacer sonido, sobreescribe el metodo de la clase base Animal
     */
    @Override
    public void hacerSonido() {
        System.out.println("Guau Guau!");
    }

}
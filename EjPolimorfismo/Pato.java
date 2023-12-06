package EjPolimorfismo;

/**
 * Clase derivada Pato, extiende de la clase Animal
 * 
 * @author Salvado Gonzalez Arellano
 * @version 1.0
 */
public class Pato extends Animal {

    /**
     * metodo hacer sonido, sobreescribe el metodo de la clase base Animal
     */
    @Override
    public void hacerSonido() {
        System.out.println("Cuack Cuack!");
    }

}
/**
 * Clase Punto para almacenar las coordenadas cartesianas x, y
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
class Punto {
    private int x, y;
    
    /**
     * Constructor de la calse para inicializar las coordenadas x, y
     * @param x valor de la coordenada x
     * @param y valor de la coordenada y
     */
    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor de la clase para inicializar las coordenadas a 0
     */
    public Punto() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Función para devolver el valor de la coordenada x
     * @return valor de la coordenada x
     */
    public int getX() {
        return x;
    }

    /**
     * Función para asignar un valor a la coordenada x
     * @param x valor para la coordenada x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Función para devolver el valor de la coordenada y
     * @return valor de la coordenada y
     */
    public int getY() {
        return y;
    }

    /**
     * Función para asignar un valor a la coordenada x
     * @param y valor para la coordenada y
     */
    public void setY(int y) {
        this.y = y;
    }
    
}
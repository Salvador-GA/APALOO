package ColasEnlazadasSimples;

/**
 * Clase Principal, utiliza los metodos de una lista enlazada simple para
 * verificar su correcto funcionamiento
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {

    public static void main(String[] args) {
        ColaEnlazadaSimple c1 = new ColaEnlazadaSimple();

        System.out.println("-------------- Encolar a ---------------");
        c1.encolar("a");
        System.out.println(c1.toString() + " longitud: " + c1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("-------------- Encolar b ---------------");
        c1.encolar("b");
        System.out.println(c1.toString() + " longitud: " + c1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("-------------- Encolar c ---------------");
        c1.encolar("c");
        System.out.println(c1.toString() + " longitud: " + c1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("-------------- Encolar d ---------------");
        c1.encolar("d");
        System.out.println(c1.toString() + " longitud: " + c1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("-------------- Encolar e ---------------");
        c1.encolar("e");
        System.out.println(c1.toString() + " longitud: " + c1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("-------------- Cola vacia? -------------");
        System.out.println("Cola vacia: "+c1.esVacia());
        System.out.println("----------------------------------------");

        System.out.println("--------------- buscar d ---------------");
        int posicion = c1.buscar("d");
        if(posicion != -1){
            System.out.println("dato d encontrado en la posicion "+posicion);
        } else {
            System.out.println("dato d no encontrado");
        }
        System.out.println("----------------------------------------");

        System.out.println("---------------- frente ----------------");
        System.out.println("Elemento al frente de la cola: "+c1.frente());
        System.out.println("----------------------------------------");

        System.out.println("--------------- desencolar -------------");
        if(c1.desencolar()){
            System.out.println("Borrado correcto");
        } else {
            System.out.println("No se pudo borrar");
        }
        System.out.println(c1.toString() + " longitud: " + c1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("--------------- desencolar -------------");
        if(c1.desencolar()){
            System.out.println("Borrado correcto");
        } else {
            System.out.println("No se pudo borrar");
        }
        System.out.println(c1.toString() + " longitud: " + c1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("--------------- desencolar -------------");
        if(c1.desencolar()){
            System.out.println("Borrado correcto");
        } else {
            System.out.println("No se pudo borrar");
        }
        System.out.println(c1.toString() + " longitud: " + c1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("---------------- frente ----------------");
        System.out.println("Elemento al frente de la cola: "+c1.frente());
        System.out.println("----------------------------------------");
    }
}

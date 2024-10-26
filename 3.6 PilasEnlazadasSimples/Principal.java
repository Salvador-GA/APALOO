/**
 * Clase Principal, utiliza los metodos de una lista enlazada simple para
 * verificar su correcto funcionamiento
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {

    public static void main(String[] args) {
        PilaEnlazadaSimple p1 = new PilaEnlazadaSimple();

        System.out.println("-------------- Apilar a ----------------");
        p1.apilar("a");
        System.out.println(p1.toString() + " longitud: " + p1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("-------------- Apilar b ----------------");
        p1.apilar("b");
        System.out.println(p1.toString() + " longitud: " + p1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("-------------- Apilar c ----------------");
        p1.apilar("c");
        System.out.println(p1.toString() + " longitud: " + p1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("-------------- Apilar d ----------------");
        p1.apilar("d");
        System.out.println(p1.toString() + " longitud: " + p1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("-------------- Apilar e ----------------");
        p1.apilar("e");
        System.out.println(p1.toString() + " longitud: " + p1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("-------------- Pila vacia? -------------");
        System.out.println("Pila vacia: "+p1.esVacia());
        System.out.println("----------------------------------------");

        System.out.println("--------------- buscar d ---------------");
        int posicion = p1.buscar("d");
        if(posicion != -1){
            System.out.println("dato d encontrado en la posicion "+posicion);
        } else {
            System.out.println("dato d no encontrado");
        }
        System.out.println("----------------------------------------");

        System.out.println("---------------- frente ----------------");
        System.out.println("Elemento al frente de la pila: "+p1.frente());
        System.out.println("----------------------------------------");

        System.out.println("--------------- Desapilar --------------");
        if(p1.desapilar()){
            System.out.println("Borrado correcto");
        } else {
            System.out.println("No se pudo borrar");
        }
        System.out.println(p1.toString() + " longitud: " + p1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("--------------- Desapilar --------------");
        if(p1.desapilar()){
            System.out.println("Borrado correcto");
        } else {
            System.out.println("No se pudo borrar");
        }
        System.out.println(p1.toString() + " longitud: " + p1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("--------------- Desapilar --------------");
        if(p1.desapilar()){
            System.out.println("Borrado correcto");
        } else {
            System.out.println("No se pudo borrar");
        }
        System.out.println(p1.toString() + " longitud: " + p1.longitud());
        System.out.println("----------------------------------------");

        System.out.println("---------------- frente ----------------");
        System.out.println("Elemento al frente de la pila: "+p1.frente());
        System.out.println("----------------------------------------");
    }
}

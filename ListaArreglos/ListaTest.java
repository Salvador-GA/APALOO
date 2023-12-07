package ListaArreglos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/**
 * Clase que realiza pruebas a la clase Lista con el paquete JUnit
 */
public class ListaTest {

    /**
     * Aquí verificamos que el llamado re las funciones regrese el valor esperado
     */
    @Test
    public void pruebas() {
        Lista l1 = new Lista(5);

        assertEquals(true, l1.insertarInicio("a"));
        assertEquals(true, l1.insertarInicio("b"));
        assertEquals(true, l1.insertarFinal("c"));
        assertEquals(true, l1.insertar("d", 1));
        assertEquals(true, l1.insertar("e", 3));
        assertEquals(false, l1.insertar("f", 1));
        assertEquals(false, l1.esVacia());
        assertEquals(true, l1.esLlena());
        assertEquals(1, l1.buscar("d"));
        assertEquals(-1, l1.buscar("z"));
        assertEquals("e", l1.devolver(3));
        assertEquals(true, l1.reemplazar("g", 3));
        assertEquals(true, l1.eliminarInicio());
        assertEquals(true, l1.eliminarFinal());
        assertEquals(true, l1.eliminar(1));
        assertEquals(false, l1.eliminar(3));
    }

    /**
     * Aqui verificamos que el estado de la lista sea el esperado, despues de usar
     * una funcion que potencialmente modifica la lista
     */
    @Test
    public void estadoLista() {
        Lista l1 = new Lista(5);

        assertEquals("[]", l1.toString());
        l1.insertarInicio("a");
        assertEquals("[a]", l1.toString());
        l1.insertarInicio("b");
        assertEquals("[b, a]", l1.toString());
        l1.insertarFinal("c");
        assertEquals("[b, a, c]", l1.toString());
        l1.insertar("d", 1);
        assertEquals("[b, d, a, c]", l1.toString());
        l1.insertar("e", 3);
        assertEquals("[b, d, a, e, c]", l1.toString());
        l1.insertar("f", 1);
        assertEquals("[b, d, a, e, c]", l1.toString());
        l1.reemplazar("g", 3);
        assertEquals("[b, d, a, g, c]", l1.toString());
        l1.eliminarInicio();
        assertEquals("[d, a, g, c]", l1.toString());
        l1.eliminarFinal();
        assertEquals("[d, a, g]", l1.toString());
        l1.eliminar(1);
        assertEquals("[d, g]", l1.toString());
        l1.eliminar(3);
        assertEquals("[d, g]", l1.toString());
    }
}

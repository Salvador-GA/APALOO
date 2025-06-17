/**
 * Clase Principal, utiliza los metodos de una lista para
 * verificar su correcto funcionamiento
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.0
 */
public class Principal {

    public static void main(String[] args) {
        Lista empleados = new Lista(10);
		empleados.insertarInicio(new Empleado("Alice", 31, 10000));
		empleados.insertarInicio(new Empleado("Bob", 43, 1000));
		empleados.insertarInicio(new Programador("Charles", 17, 9000000, "Java"));
		System.out.println(empleados.toString());
		int indice = empleados.buscar(new Programador("Charles", 23, 200000, "Java"));
		System.out.println("indice de Bob: "+indice);
		empleados.insertar(new Empleado("Dana", 37, 150000), 1);
	    System.out.println(empleados.devolver(0));
		System.out.println(empleados);
		empleados.reemplazar(new Programador("Erick", 15, 160000, "Java"), 2);
		System.out.println(empleados);
		System.out.println(empleados.edadPromedio());
		System.out.println(empleados.maxSalario());
		System.out.println(empleados.empMaxSalario());
		System.out.println(empleados.existeMenor());
		empleados.eliminarMenores();
		System.out.println(empleados);
		empleados.incrementoSalario(5);
		System.out.println(empleados);
    }
}

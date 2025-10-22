import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Principal {
    public static void main(String[] args) {
        // ---------------------------------------------------
        // Ejemplo 1: Parseo simple (fecha imposible)
        // ---------------------------------------------------
        System.out.println("\nEjemplo de fecha simple");
        String fechaInvalida = "2025-02-30"; // febrero 30 no existe

        try {
            LocalDate f = LocalDate.parse(fechaInvalida); // ISO_LOCAL_DATE por defecto (yyyy-MM-dd)
            System.out.println("Fecha válida: " + f);
        } catch (DateTimeParseException dtpe) {
            System.out.println("Error: Fecha con formato inválido o imposible -> " + fechaInvalida);
            System.out.println("Detalle: " + dtpe.getMessage());
        }

        // ---------------------------------------------------
        // Ejemplo 2: Arreglo de fechas (try-catch fuera del ciclo)
        // Un solo try-catch envuelve el for completo:
        // Si ocurre una excepción, se rompe el ciclo inmediatamente.
        // ---------------------------------------------------
        System.out.println("\nEjemplo de arreglo de fechas (try-catch FUERA del ciclo)");
        String[] arregloFechas = {
            "2024-12-01",  // válida
            "1999-02-29",  // 1999 no es bisiesto -> inválida
            "2020-02-29",  // válida (bisiesto)
            "01/03/2024",  // formato inválido para ISO (espera yyyy-MM-dd)
            null,          // NullPointerException
            "2024-13-10",  // mes 13 -> inválida
            "2024-11-31"   // noviembre tiene 30 días -> inválida
        };

        try {
            for (String s : arregloFechas) {
                LocalDate f = LocalDate.parse(s); // usa ISO yyyy-MM-dd
                System.out.println("OK: " + s + " -> " + f);
            }
        } catch (NullPointerException npe) {
            System.out.println("Error: cadena de fecha es null");
        } catch (DateTimeParseException dtpe) {
            System.out.println("Error: formato o valor de fecha inválido en el arreglo");
            System.out.println("Detalle: " + dtpe.getMessage());
        }

        // ---------------------------------------------------
        // Ejemplo 3: Arreglo de fechas (try-catch DENTRO del ciclo)
        // Un try-catch por elemento: el ciclo continúa aunque algún elemento falle.
        // ---------------------------------------------------
        System.out.println("\nEjemplo de arreglo de fechas (try-catch DENTRO del ciclo)");
        for (String s : arregloFechas) {
            try {
                LocalDate f = LocalDate.parse(s);
                System.out.println("OK: " + s + " -> " + f);
            } catch (NullPointerException npe) {
                System.out.println("Fecha null (elemento omitido)");
            } catch (DateTimeParseException dtpe) {
                System.out.println("Fecha inválida: \"" + s + "\" (formato esperado yyyy-MM-dd o valor imposible)");
            }
        }
    }
}

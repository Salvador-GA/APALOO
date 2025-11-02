# Pruebas automatizadas con JUnit 5

## 1) ¿Qué son las pruebas automatizadas?
Las **pruebas automatizadas** son **programas que verifican a otros programas**. Se escriben como código (tests) que se ejecuta de forma repetible y sin intervención manual para comprobar que el sistema cumple reglas, contratos y comportamientos esperados.

### ¿Por qué usarlas?
- **Retroalimentación temprana:** detectan errores justo después de un cambio.  
- **Prevención de regresiones:** aseguran que lo que ya funcionaba **sigue** funcionando.  
- **Documentación ejecutable:** los tests describen con ejemplos el uso correcto de la API.  
- **Diseño más limpio (TDD):** fomenta código desacoplado y testeable.  
- **Base para CI/CD:** verificaciones en cada *commit* y antes de desplegar.

### ¿Cuándo automatizar?
- Reglas de negocio estables o críticas.  
- Funciones puras, cálculos, validaciones y transformaciones de datos.  
- Contratos de servicios (entradas/salidas bien definidas).  
- Bugs reproducibles: escribe primero un test que falle, **luego** corrige el bug.

### ¿Cuándo no conviene (o conviene menos)?
- Prototipos efímeros.  
- UIs que cambian muy rápido (mantener solo flujos clave).  
- Funcionalidad con alta dependencia de hardware/entornos no deterministas (si no puedes aislar/simular).

### Errores comunes a evitar
- Tests **frágiles/inestables** (*flaky*): dependen del reloj, red o concurrencia sin control.  
- Aserciones poco claras.  
- Demasiadas verificaciones en un solo test.  
- No aislar dependencias (la “unitaria” termina siendo de integración).

---

## 2) Conceptos generales
- **Caso de prueba:** verificación atómica de un comportamiento (entrada, operación, salida/estado).  
- **Suite de pruebas:** colección organizada de casos (por módulo/paquete/feature).  
- **Aserciones (asserts):** comparaciones que dictan *pasa/falla* (igualdad, excepciones, predicados).  
- **Fixtures:** preparación/limpieza del entorno de prueba (JUnit: @BeforeEach, @AfterEach).  
- **Doubles de prueba:** Stub (respuestas fijas), Mock (verifica interacciones), Fake (impl. simplificada).  
- **Determinismo:** mismo input ⇒ mismo output; evita dependencias de reloj, IO, red.  
- **Cobertura:** % de código ejecutado (líneas, ramas, mutación): guía, no fin.  
- **Patrón AAA:** Arrange → Act → Assert.  
- **TDD:** Red → Green → Refactor.

---

## 3) Tipos comunes de pruebas automatizadas
**Orden típico:** de más baratas/rápidas a más caras/lentas.

### Unitarias
- **Qué:** una **unidad** (función/método/clase) en aislamiento.  
- **Objetivo:** corrección, bordes (nulos, vacíos, límites), excepciones, contratos.  
- **Rasgos:** muy rápidas (<ms), muchas, sin IO externo.  
- **Herramientas (Java):** **JUnit 5**, Mockito, AssertJ/Hamcrest.

### De integración
- **Qué:** integración entre módulos o con recursos reales/simulados (DB, colas, servicios).  
- **Objetivo:** contratos entre componentes, mapeos, transacciones, serialización.  
- **Rasgos:** más lentas; se benefician de contenedores efímeros.  
- **Herramientas:** Testcontainers, H2/Derby, Spring Test, REST Assured.

### Funcionales / End-to-End (E2E)
- **Qué:** flujos completos de usuario/negocio.  
- **Objetivo:** validar el sistema “de punta a punta”.  
- **Rasgos:** las más lentas y frágiles; usar pocas pero representativas.  
- **Herramientas:** Selenium, Playwright; para APIs, Postman CLI/REST Assured.

### De contratos
- **Qué:** cumplimiento de la API hacia consumidores (y viceversa).  
- **Herramientas:** Pact, Spring Cloud Contract.

### Regresión
- **Qué:** que errores pasados no regresen.

### Rendimiento (performance/load/stress)
- **Qué:** tiempos de respuesta, throughput, degradación bajo carga, latencias.  
- **Herramientas:** JMeter, Gatling.

### Seguridad
- **Qué:** inyecciones, authN/authZ, secretos.  
- **Referencias:** OWASP; escáneres dinámicos/estáticos.

### Property-based testing
- **Qué:** **propiedades** invariantes con datos generados; jqwik (JUnit 5).

**Pirámide de pruebas:** muchas **unitarias**, algunas **integración**, pocas **E2E**.

---

## 4) Herramientas populares (panorama)

| Propósito              | Herramientas (ejemplos)                         |
|------------------------|--------------------------------------------------|
| **Unitarias (Java)**   | **JUnit 5**, TestNG                              |
| **Dobles/Mocks**       | Mockito, EasyMock                                |
| **Asserts extra**      | AssertJ, Hamcrest                                |
| **Cobertura**          | JaCoCo, Cobertura                                |
| **Integración/DB**     | Testcontainers, H2/Derby embebido                |
| **E2E Web**            | Selenium, Playwright, Cypress* (*JS*)            |
| **API/Contratos**      | REST Assured, Pact                               |
| **Rendimiento**        | JMeter, Gatling                                  |
| **CI/CD**              | GitHub Actions, GitLab CI, Jenkins               |
| **Android**            | Espresso, Robolectric                             |
| **Property-based**     | jqwik (JUnit 5)                                  |

> En Java puro: **JUnit 5 + Mockito + AssertJ + JaCoCo**.

---

## 5) Flujo de trabajo recomendado
1. **Estructura** el proyecto.  
2. **Nombra** tests en espejo: ClaseXTest.  
3. **Aísla** dependencias en unitarias (mocks/stubs).  
4. **Ejecuta** en local y **CI** en cada commit.  
5. **Mide** cobertura y prioriza código crítico y bordes.  
6. Considera **TDD** o al menos test para cada bug antes de arreglarlo.

---

## 6) Pruebas unitarias con JUnit 5 (Jupiter)

### 6.1. Dependencias mínimas

Maven (pom.xml)

    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>5.10.2</version>
      <scope>test</scope>
    </dependency>

Surefire 3.x

    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-plugin</artifactId>
      <version>3.2.5</version>
    </plugin>

Gradle (Groovy)

    test { useJUnitPlatform() }
    dependencies { testImplementation 'org.junit.jupiter:junit-jupiter:5.10.2' }

### 6.2. Anatomía de un test

    import org.junit.jupiter.api.*;
    import static org.junit.jupiter.api.Assertions.*;
    
    class CalculadoraTest {
    
      @BeforeEach
      void setUp() { /* prepara fixture */ }
    
      @AfterEach
      void tearDown() { /* limpia si es necesario */ }
    
      @Test
      @DisplayName("Suma básica 2 + 2 = 4")
      void sumaBasica() {
        assertEquals(4, 2 + 2);
      }
    }

### 6.3. Aserciones útiles

    assertEquals(esperado, real);
    assertTrue(condicion);
    assertFalse(condicion);
    assertThrows(IllegalArgumentException.class, () -> metodoQueDebeLanzar());
    assertAll(
      () -> assertEquals(3, sumar(1,2)),
      () -> assertTrue(esPar(4))
    );

### 6.4. Pruebas parametrizadas

    import org.junit.jupiter.params.ParameterizedTest;
    import org.junit.jupiter.params.provider.CsvSource;
    
    class SumarTest {
      @ParameterizedTest(name = "{0} + {1} = {2}")
      @CsvSource({"1,2,3", "-1,5,4", "0,0,0"})
      void sumar(int a, int b, int esperado) {
        assertEquals(esperado, a + b);
      }
    }

Desde archivo CSV

    import org.junit.jupiter.params.provider.CsvFileSource;
    
    @ParameterizedTest
    @CsvFileSource(resources = "/datos/sumas.csv", numLinesToSkip = 1)
    void sumarDesdeCSV(int a, int b, int esperado) { /* ... */ }
    
Estructura de recursos: src/test/resources/datos/sumas.csv.

### 6.5. Verificación de excepciones

    @Test
    void divisionPorCeroLanzaExcepcion() {
      assertThrows(ArithmeticException.class, () -> dividir(5, 0));
    }

### 6.6. Mockito (dobles de prueba)

    import static org.mockito.Mockito.*;
    import org.junit.jupiter.api.Test;
    
    class ServicioTest {
      @Test
      void usaRepositorioSimulado() {
        Repositorio repo = mock(Repositorio.class);
        when(repo.findById(1L)).thenReturn(new Entidad(1L, "ok"));
    
        Servicio s = new Servicio(repo);
        var r = s.obtener(1L);
    
        verify(repo).findById(1L); // interacción esperada
        // assertEquals(...);      // resultados esperados
      }
    }

### 6.7. Patrón AAA en práctica

    @Test
    void factorial_ok_y_negativo() {
      assertAll(
        () -> assertEquals(120, factorial(5)),
        () -> assertThrows(IllegalArgumentException.class, () -> factorial(-1))
      );
    }

---

## 7) Buenas prácticas (checklist)
- Nombres claros o @DisplayName.  
- Tests **atómicos** (un motivo principal de fallo).  
- Cubre **bordes** y **excepciones**.  
- Sin lógica compleja en los tests.  
- Sin dependencias externas en unitarias (o simúlalas).  
- Rápidos y deterministas.

---

## 8) Ejemplo compacto: clase + pruebas (JUnit 5)

Código de producción

    public final class MathUtils {
      private MathUtils(){}
    
      public static int sumar(int a, int b) { return a + b; }
    
      public static double dividir(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("División entre cero");
        return (double) a / b;
      }
    
      public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n < 0");
        long res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
      }
    }

Pruebas

    import org.junit.jupiter.api.*;
    import org.junit.jupiter.params.ParameterizedTest;
    import org.junit.jupiter.params.provider.CsvSource;
    import static org.junit.jupiter.api.Assertions.*;
    
    class MathUtilsTest {
    
      @ParameterizedTest(name = "{0} + {1} = {2}")
      @CsvSource({"1,2,3", "-1,5,4", "0,0,0"})
      void sumar_parametrizado(int a, int b, int esperado) {
        assertEquals(esperado, MathUtils.sumar(a, b));
      }
    
      @Test
      void dividir_ok_y_error() {
        assertEquals(2.5, MathUtils.dividir(5, 2), 1e-9);
        assertThrows(IllegalArgumentException.class, () -> MathUtils.dividir(1, 0));
      }
    
      @Test
      void factorial_basicos() {
        assertAll(
          () -> assertEquals(1, MathUtils.factorial(0)),
          () -> assertEquals(120, MathUtils.factorial(5))
        );
      }
    }

---

## 9) Conclusión
- Las **pruebas automatizadas** son tu primera línea de defensa.  
- Construye sobre **unitarias con JUnit 5** y añade integración, E2E y métricas a medida que el proyecto crece.  
- Usa **CI** para ejecutarlas siempre y mantener el código sano.
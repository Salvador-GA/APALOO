En este ejemplo encontrará la forma de declarar una clase abstracta en Java, así como la forma de sobreescribir los métodos abstractos en las clases derivadas
```mermaid
classDiagram
    class <<abstract>> Figura {
        +calcularArea():double
        +calcularPerimetro():double
        +toString():String
    }

    class Circulo {
        -radio:double
        +Circulo()
        +Circulo(radio:double)
        +getRadio():double
        +setRadio(double radio):void
    }

    class Rectangulo {
        -base:double
        -altura:double
        +Rectangulo()
        +Rectangulo(base:double, altura:double)
        +getBase():double
        +setBase(double base):void
        +getAltura():double
        +setAltura(double altura):void
    }

    class Cuadrado {
        +Cuadrado()
        +Cuadrado(lado:double)
        +setBase(double base):void <<Override>>
        +setAltura(double altura):void <<Override>>
    }

    Figura <|-- Circulo : extends
    Figura <|-- Rectangulo : extends
    Rectangulo <|-- Cuadrado : extends
```

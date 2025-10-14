En este ejemplo se muestra como se deriva una clase, de una clase base. Concepto de herencia

```mermaid
classDiagram
    class Esfera {
        -radio: double
        +Esfera()
        +Esfera(radio: double)
        +getRadio(): double
        +setRadio(radio: double): void
        +superficie(): double
        +toString(): String
    }

    class Planeta {
        -numSatelites: int
        +Planeta()
        +Planeta(radio: double)
        +Planeta(radio: double, numSatelites: int)
        +getNumSatelites(): int
        +setNumSatelites(numSatelites: int): void
        +toString(): String // override
    }

    Esfera <|-- Planeta
```
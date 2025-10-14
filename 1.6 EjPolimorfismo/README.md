En este ejemplo se presenta el uso del polimorfismo

```mermaid
classDiagram
    class Animal {
        <<abstract>>
        +hacerSonido(): void // abstract
    }

    class Gato {
        
    }

    class Pato {
        
    }

    class Perro {
        
    }

    Animal <|-- Gato
    Animal <|-- Pato
    Animal <|-- Perro
```

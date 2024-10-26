public class Principal {
    public static void main(String[] args) throws Exception {
        Animal[] animales = new Animal[6];
        animales[0] = new Perro();
        animales[1] = new Gato();
        animales[2] = new Pato();
        animales[3] = new Gato();
        animales[4] = new Pato();
        animales[5] = new Perro();
        for (int i = 0; i < 6; i++) {
            if (animales[i] instanceof Perro) {
                System.out.print("El perro hace: ");
            } else if (animales[i] instanceof Gato) {
                System.out.print("El gato hace: ");
            } else if (animales[i] instanceof Pato) {
                System.out.print("El pato hace: ");
            }
            animales[i].hacerSonido();
        }
    }
}
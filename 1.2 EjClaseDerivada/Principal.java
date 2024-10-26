public class Principal {

    public static void main(String[] args) {
        Esfera miesfera1 = new Esfera();
        Esfera miesfera2;
        Esfera miesfera3 = new Esfera(2.0);

        miesfera1.setRadio(1.0);
        miesfera2 = miesfera1;
        System.out.println("Las referencias miesfera1 y miesfera2 " + (miesfera1 == miesfera2 ? "si" : "no")
                + " apuntan al mismo objeto");
        System.out.println("Las referencias miesfera3 y miesfera1 " + (miesfera3 == miesfera1 ? "si" : "no")
                + " apuntan al mismo objeto");
        Planeta tierra = new Planeta(6378, 1);
        double superficie = tierra.superficie();
        System.out.println("La superficie de la tierra es: " + superficie + " km y cuenta con "
                + tierra.getNumSatelites() + " satelite");
        System.out.println("string de tierra: " + tierra.toString());
        System.out.println("string de miesfera3: " + miesfera3.toString());
    }
}
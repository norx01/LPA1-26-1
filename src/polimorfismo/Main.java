package polimorfismo;

public class Main
{
    public static void main(String[] args)
    {
        Animales animal1 = new Perro();
        Animales animal2 = new Gato();

        animal1.hacerSonido();
        animal2.hacerSonido();
    }
}

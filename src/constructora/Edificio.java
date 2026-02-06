package constructora;

/**
 * Clase Edificio, es la encargada de crear el modelo para los edificios
 * @author Juan
 * @version 1.0
 */
public class Edificio
{
    /**
     * atributo nombre, encargado de almacenar el nombre del edificio
     */
    private String nombre;
    /**
     * atributo pisos, encargado de almacenar el numero de pisos del edificio
     */
    private int pisos;
    /**
     * atributo altura, encargado de almacenar la altura del edificio
     */
    private int altura;
    /**
     * atributo num_apartamento, encargado de almacenar el numero de apartamentos del edificio
     */
    private int num_apartamentos;
    /**
     * atributo ascensor, encargado de almacenar si el edificio tiene ascensor o no
     */
    private boolean ascensor;
    /**
     * atributo parqueadero, encargado de almacenar si el edificio tiene parqueadero o no
     */
    private boolean parqueadero;

    /**
     * Constructor de la clase Edificio, crea un edificio
     * @param nombre
     * @param pisos
     * @param altura
     * @param num_apartamentos
     * @param ascensor
     * @param parqueadero
     */
    public Edificio(String nombre, int pisos, int altura, int num_apartamentos, boolean ascensor, boolean parqueadero) {
        this.nombre = nombre;
        this.pisos = pisos;
        this.altura = altura;
        this.num_apartamentos = num_apartamentos;
        this.ascensor = ascensor;
        this.parqueadero = parqueadero;
    }

    /**
     * Metodo getNombre, retorna el nombre del edificio
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getNum_apartamentos() {
        return num_apartamentos;
    }

    public void setNum_apartamentos(int num_apartamentos) {
        this.num_apartamentos = num_apartamentos;
    }

    public boolean isAscensor() {
        return ascensor;
    }

    public void setAscensor(boolean ascensor) {
        this.ascensor = ascensor;
    }

    public boolean isParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(boolean parqueadero) {
        this.parqueadero = parqueadero;
    }

    public void ingresar()
    {
        System.out.println("Ingreso al edificio");
    }

    public String salir()
    {
        return "Salio del edificio";
    }

    public void habitar()
    {
        System.out.println("Estoy habitando en el edificio");
    }

}

package trabajadores;

/**
 * Representa el modelo un trabajador con sus atributos
 * @author Juan
 * @version 1.0
 */
public class Trabajador
{
    /**
     * Nombre del trabajador
     */
    private String nombre;
    /**
     * Cedula del trabajador
     */
    private int cedula;
    /**
     * Edad del trabajador
     */
    private int edad;
    /**
     * Telefono del trabajador
     */
    private int telefono;
    /**
     * Direccion del trabajador
     */
    private String direccion;
    /**
     * Cargo del trabajador
     */
    private String cargo;

    /**
     * Constructor de la clase, crea un trabajador
     * @param nombre es el nombre del trabajador
     * @param cedula es la cedula del trabajador
     * @param edad es la edad del trabajador
     * @param telefono es el telefono del trabajador
     * @param direccion es la direccion del trabajador
     * @param cargo es el cargo del trabajador
     */
    public Trabajador(String nombre, int cedula, int edad, int telefono, String direccion, String cargo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cargo = cargo;
    }

    /**
     *
     * @return es el cargado de retornar el nombre del trabajador
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}

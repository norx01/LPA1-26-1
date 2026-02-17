package ESport;

public class Jugador
{
    private String idGamer;
    private String nickname;
    private String rol;
    private String equipo;
    private int edad;
    private double salarioMensual;
    private int nivel;
    private double clausulaSalida;
    private int umbralAlerta;

    public Jugador(String idGamer, String nickname, String rol, String equipo, int edad, double salarioMensual, int nivel, double clausulaSalida, int umbralAlerta) {
        this.idGamer = idGamer;
        this.nickname = nickname;
        this.rol = rol;
        this.equipo = equipo;
        this.edad = edad;
        this.salarioMensual = salarioMensual;
        this.nivel = nivel;
        this.clausulaSalida = clausulaSalida;
        this.umbralAlerta = umbralAlerta;
    }

    public String getIdGamer() {
        return idGamer;
    }

    public void setIdGamer(String idGamer) {
        this.idGamer = idGamer;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getClausulaSalida() {
        return clausulaSalida;
    }

    public void setClausulaSalida(double clausulaSalida) {
        this.clausulaSalida = clausulaSalida;
    }

    public int getUmbralAlerta() {
        return umbralAlerta;
    }

    public void setUmbralAlerta(int umbralAlerta) {
        this.umbralAlerta = umbralAlerta;
    }
}

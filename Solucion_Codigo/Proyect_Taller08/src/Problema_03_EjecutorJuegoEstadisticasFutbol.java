
abstract class Jugador {

    protected String nombre;
    protected int dorsal;
    protected String rut;
    protected int goles;
    protected double valoracion;

    public Jugador(String nombre, int dorsal, String rut, int goles) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.rut = rut;
        this.goles = goles;
    }

    public abstract void calcularValoracion();

    public double getValoracion() {
        return valoracion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nDorsal: " + dorsal + "\nRUT: " + rut
                + "\nGoles: " + goles + "\nValoracion: " + valoracion;
    }
}

class Atacante extends Jugador {

    private int pasesExito;
    private int recuperaciones;

    public Atacante(String nombre, int dorsal, String rut, int goles, int pasesExito, int recuperaciones) {
        super(nombre, dorsal, rut, goles);
        this.pasesExito = pasesExito;
        this.recuperaciones = recuperaciones;
        calcularValoracion();
    }

    @Override
    public void calcularValoracion() {
        valoracion = (goles * 30) + (recuperaciones * 3);
    }

    @Override
    public String toString() {
        return "=== ATACANTE ===\n"
                + super.toString()
                + "\nPases exitosos: " + pasesExito
                + "\nRecuperaciones: " + recuperaciones;
    }
}

class Defensor extends Jugador {

    private int pasesExito;
    private int recuperaciones;

    public Defensor(String nombre, int dorsal, String rut, int goles, int pasesExito, int recuperaciones) {
        super(nombre, dorsal, rut, goles);
        this.pasesExito = pasesExito;
        this.recuperaciones = recuperaciones;
        calcularValoracion();
    }

    @Override
    public void calcularValoracion() {
        valoracion = (goles * 30) + (recuperaciones * 4);
    }

    @Override
    public String toString() {
        return "=== DEFENSOR ===\n" + super.toString() + "\nPases exitosos: " + pasesExito
                + "\nRecuperaciones: " + recuperaciones;
    }
}

class Portero extends Jugador {

    private int atajadas;

    public Portero(String nombre, int dorsal, String rut, int goles, int atajadas) {
        super(nombre, dorsal, rut, goles);
        this.atajadas = atajadas;
        calcularValoracion();
    }

    @Override
    public void calcularValoracion() {
        valoracion = (goles * 30) + (atajadas * 5);
    }

    @Override
    public String toString() {
        return "=== PORTERO ===\n" + super.toString() + "\nAtajadas: " + atajadas;
    }
}

public class Problema_03_EjecutorJuegoEstadisticasFutbol {

    public static void main(String[] args) {
        Jugador[] jugadores = new Jugador[3];
        jugadores[0] = new Atacante("Carlos", 9, "1101111111", 2, 35, 8);
        jugadores[1] = new Defensor("Pedro", 4, "1102222222", 1, 40, 12);
        jugadores[2] = new Portero("Luis", 1, "1103333333", 0, 15);
        for (Jugador j : jugadores) {
            System.out.println(j);
            System.out.println("---------------------------");
        }
    }
}

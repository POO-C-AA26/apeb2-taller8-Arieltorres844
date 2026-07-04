/*
Problema03:Se desea realizar una aplicación que permita a un periodista 
deportivo llevar las estadísticas de los jugadores de un equipo de fútbol para 
poder valorar su actuación en el partido.
Cada jugador se identifica por su nombre, número de dorsal y Rut
Los jugadores se dividen en tres categorías:
Atacantes
Defensores
Porteros
Para todos los jugadores se desea contabilizar el número de goles marcados, 
además en el caso de los jugadores de campo se contabilizan los pases realizados
con éxito y el número de balones recuperados. En el caso de los porteros se 
contabilizan las atajadas realizadas.
@autor: Ariel Torres
@version: 1.0
 */
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
/*
run:
=== ATACANTE ===
Nombre: Carlos
Dorsal: 9
RUT: 1101111111
Goles: 2
Valoracion: 84.0
Pases exitosos: 35
Recuperaciones: 8
---------------------------
=== DEFENSOR ===
Nombre: Pedro
Dorsal: 4
RUT: 1102222222
Goles: 1
Valoracion: 78.0
Pases exitosos: 40
Recuperaciones: 12
---------------------------
=== PORTERO ===
Nombre: Luis
Dorsal: 1
RUT: 1103333333
Goles: 0
Valoracion: 75.0
Atajadas: 15
---------------------------
*/
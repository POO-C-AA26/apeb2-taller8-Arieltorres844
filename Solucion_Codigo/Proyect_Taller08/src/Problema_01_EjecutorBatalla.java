
import java.util.Random;

/*
Problema01:Una red de monitoreo ambiental tiene como objetivo registrar, 
analizar y reportar los impactos del cambio climático en diferentes regiones. 
En cada ubicación se instalan dispositivos capaces de medir distintos 
indicadores climáticos como temperatura, precipitación, calidad del aire, y
humedad del suelo. Dependiendo de la región (costa, sierra y oriente), los 
dispositivos pueden variar en capacidades y protocolos de recolección.

Los datos recolectados deben almacenarse y analizarse periódicamente. Además, 
ciertas ubicaciones requieren generar reportes personalizados que destaquen 
riesgos ambientales como sequías, deslizamientos o contaminación del aire. 
Algunos dispositivos pueden comportarse de forma especializada para detectar 
únicamente ciertos tipos de indicadores dependiendo de la región (costa, sierra
y oriente).

Requisitos funcionales:
Representar diferentes tipos de dispositivos y sus especializaciones, para la 
costa, sierra y oriente.
Implementar métodos polimórficos que permitan procesar los datos según los tipos
de dispositivos y sus especializaciones, para la costa, sierra y oriente.
Generar reportes dinámicos en función del tipo de riesgo ambiental detectado 
según la región
@autor: Ariel Torres
@version: 1.0
 */
import java.util.Random;

abstract class Personaje {

    public int vida, experiencia, batallasGanadas;

    public Personaje(int vida) {
        this.vida = vida;
    }

    public abstract boolean ataque(Personaje personaje);

    public abstract boolean defensa(Personaje personaje);

    @Override
    public String toString() {
        return "vida=" + vida
                + ", experiencia=" + experiencia
                + ", batallasGanadas=" + batallasGanadas;
    }
}
class Guerrero extends Personaje {

    public int fuerza;

    public Guerrero(int fuerza, int vida) {
        super(vida);
        this.fuerza = fuerza;
    }

    @Override
    public boolean ataque(Personaje personaje) {

        if (this.vida <= 0 || personaje.vida <= 0) {
            return false;
        }

        experiencia++;
        personaje.experiencia++;

        Random ale = new Random();

        boolean gana = ale.nextBoolean();

        if (gana) {
            personaje.vida -= fuerza;
            batallasGanadas++;
        } else {
            vida--;
            personaje.batallasGanadas++;
        }

        if (personaje.vida < 0) {
            personaje.vida = 0;
        }

        return gana;
    }

    @Override
    public boolean defensa(Personaje personaje) {

        Random ale = new Random();

        if (ale.nextBoolean()) {
            vida++;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Guerrero{"
                + "fuerza=" + fuerza + ", "
                + super.toString()
                + "}";
    }

}
class Mago extends Personaje {

    public String hechizos[];

    public Mago(String[] hechizos, int vida) {
        super(vida);
        this.hechizos = hechizos;
    }

    @Override
    public boolean ataque(Personaje personaje) {

        if (vida <= 0 || personaje.vida <= 0) {
            return false;
        }

        experiencia++;
        personaje.experiencia++;

        Random ale = new Random();

        boolean gana = ale.nextInt(100) < 70; //70% de éxito

        if (gana) {
            personaje.vida -= 2;
            batallasGanadas++;
        } else {
            vida--;
            personaje.batallasGanadas++;
        }

        if (personaje.vida < 0) {
            personaje.vida = 0;
        }

        return gana;
    }

    @Override
    public boolean defensa(Personaje personaje) {

        Random ale = new Random();

        if (ale.nextBoolean()) {
            vida += 2;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Mago{"
                + "hechizos=" + hechizos.length
                + ", " + super.toString()
                + "}";
    }

}
class Arquero extends Personaje {

    public int precision;

    public Arquero(int precision, int vida) {
        super(vida);
        this.precision = precision;
    }

    @Override
    public boolean ataque(Personaje personaje) {

        if (vida <= 0 || personaje.vida <= 0) {
            return false;
        }

        experiencia++;
        personaje.experiencia++;

        Random ale = new Random();

        boolean gana = ale.nextInt(10) < precision;

        if (gana) {
            personaje.vida -= precision;
            batallasGanadas++;
        } else {
            vida--;
            personaje.batallasGanadas++;
        }

        if (personaje.vida < 0) {
            personaje.vida = 0;
        }

        return gana;
    }

    @Override
    public boolean defensa(Personaje personaje) {

        Random ale = new Random();

        return ale.nextBoolean();
    }

    @Override
    public String toString() {
        return "Arquero{"
                + "precision=" + precision + ", "
                + super.toString()
                + "}";
    }

}
public class Problema_01_EjecutorBatalla {

    public static void main(String[] args) {

        String hechizos[] = {
            "Abracadabra",
            "Bola de Fuego",
            "Rayo"
        };

        Personaje guerrero = new Guerrero(5, 10);
        Personaje mago = new Mago(hechizos, 8);
        Personaje arquero = new Arquero(7, 9);

        System.out.println("=== Estado Inicial ===");
        System.out.println(guerrero);
        System.out.println(mago);
        System.out.println(arquero);

        System.out.println();

        System.out.println("Guerrero ataca al Arquero");
        System.out.println("Resultado: " + guerrero.ataque(arquero));

        System.out.println();

        System.out.println("Mago ataca al Guerrero");
        System.out.println("Resultado: " + mago.ataque(guerrero));

        System.out.println();

        System.out.println("Arquero ataca al Mago");
        System.out.println("Resultado: " + arquero.ataque(mago));

        System.out.println();

        System.out.println("=== Estado Final ===");
        System.out.println(guerrero);
        System.out.println(mago);
        System.out.println(arquero);

        if (guerrero.vida <= 0) {
            System.out.println("El Guerrero ha sido derrotado.");
        }

        if (mago.vida <= 0) {
            System.out.println("El Mago ha sido derrotado.");
        }

        if (arquero.vida <= 0) {
            System.out.println("El Arquero ha sido derrotado.");
        }

    }

}
/*
run:
=== Estado Inicial ===
Guerrero{fuerza=5, vida=10, experiencia=0, batallasGanadas=0}
Mago{hechizos=3, vida=8, experiencia=0, batallasGanadas=0}
Arquero{precision=7, vida=9, experiencia=0, batallasGanadas=0}

Guerrero ataca al Arquero
Resultado: false

Mago ataca al Guerrero
Resultado: true

Arquero ataca al Mago
Resultado: true

=== Estado Final ===
Guerrero{fuerza=5, vida=7, experiencia=2, batallasGanadas=0}
Mago{hechizos=3, vida=1, experiencia=2, batallasGanadas=1}
Arquero{precision=7, vida=9, experiencia=2, batallasGanadas=2}
 */

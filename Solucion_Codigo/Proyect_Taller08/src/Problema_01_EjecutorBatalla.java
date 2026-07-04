
import java.util.Random;

/*
Problema01:En un juego de rol, se desea implementar un sistema de combate en el 
que participen diferentes tipos de personajes: guerreros, magos y arqueros. Cada
personaje tiene atributos y habilidades únicas, así como diferentes métodos de 
ataque y defensa.
El objetivo del juego es enfrentar a los personajes en batallas y determinar el 
ganador en función de sus habilidades, estrategias y atributos. Los guerreros se
destacan por su fuerza y habilidades cuerpo a cuerpo, los magos por sus hechizos
y poderes mágicos, y los arqueros por su precisión y habilidades a distancia.
El sistema debe permitir crear nuevos personajes de cada tipo, asignarles 
atributos iniciales, como puntos de vida y nivel de experiencia, y permitirles 
subir de nivel a medida que ganan batallas. Además, se debe implementar un 
algoritmo de combate que evalúe las habilidades de cada personaje y determine 
el resultado de la batalla.
Utilizando programación orientada a objetos, herencia y polimorfismo, 
implementa el sistema de combate y las clases necesarias para representar a 
los diferentes tipos de personajes. Asegúrate de que cada tipo de personaje 
tenga sus propias habilidades y métodos de ataque y defensa, y que puedan 
interactuar entre sí en las batallas
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
            this.vida++;
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

        boolean gana = ale.nextInt(100) < 70;

        if (gana) {
            personaje.vida -= 2;
            this.batallasGanadas++;
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
            this.vida += 2;
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

        this.experiencia++;
        personaje.experiencia++;

        Random ale = new Random();

        boolean gana = ale.nextInt(10) < precision;

        if (gana) {
            personaje.vida -= precision;
            this.batallasGanadas++;
        } else {
            this.vida--;
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

        String hechizos[] = {"Abracadabra","Bola de Fuego","Rayo"};

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

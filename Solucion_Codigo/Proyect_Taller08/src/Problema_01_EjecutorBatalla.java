
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
abstract class Personaje {

    public int vida, experiencia, batallasGanadas;

    public Personaje(int vida) {
        this.vida = vida;
    }

    public abstract boolean ataque(Personaje personaje);

    public abstract boolean defensa(Personaje personaje);

    @Override
    public String toString() {
        return "Personaje{" + "vida=" + vida + ", experiencia=" + experiencia + ", batallasGanadas=" + batallasGanadas + '}';
    }
}

class Guerrero extends Personaje {

    public int fuerza;

    public Guerrero(int fuerza, int vida) {
        super(vida);
        this.fuerza = fuerza;
    }

    public boolean ataque(Personaje personaje) {
        if (this.vida <= 0 || personaje.vida <= 0) {
            return false;
        }

        this.experiencia++;
        personaje.experiencia++;

        Random ale = new Random();
        boolean pelea = ale.nextBoolean();

        if (pelea) {
            this.batallasGanadas++;
            personaje.vida--;
        } else {
            this.vida--;
            personaje.batallasGanadas++;
        }

        return pelea;
    }

    public boolean defensa(Personaje personaje) {
        return false;
    }

    @Override
    public String toString() {
        return "Guerrero{" + "fuerza=" + fuerza + '}' + super.toString();
    }

}

class Mago extends Personaje {

    public String hechizos[];

    public Mago(String[] hechizos, int vida) {
        super(vida);
        this.hechizos = hechizos;
    }

    public boolean ataque(Personaje personaje) {
        return false;
    }

    public boolean defensa(Personaje personaje) {
        return false;
    }

    @Override
    public String toString() {
        return "Mago{" + "hechizos=" + hechizos + '}' + super.toString();
    }

}

class arquero extends Personaje {

    public int precision;

    public arquero(int precision, int vida) {
        super(vida);
        this.precision = precision;
    }

    public boolean ataque(Personaje personaje) {
        return false;
    }

    public boolean defensa(Personaje personaje) {
        return false;
    }

    @Override
    public String toString() {
        return "arquero{" + "precision=" + precision + '}' + super.toString();
    }
}

public class Problema_01_EjecutorBatalla {

    public static void main(String[] args) {
        String hechizos[] = {"abracadabra", "poderesMagicosFuerza"};
        Personaje guerrero = new Guerrero(5, 2);
        Personaje mago = new Mago(hechizos, 1);
        Personaje arquero = new arquero(4, 3);
        System.out.println("result. ataque al gerrero:" + guerrero.ataque(arquero));
        guerrero.ataque(arquero);
        guerrero.ataque(arquero);
        guerrero.ataque(arquero);
        if (guerrero.vida <= 0) {
            System.out.println("El guerrero no puede pelear mas, no tiene vida.");
        }

        if (arquero.vida <= 0) {
            System.out.println("El personaje rival no puede pelear mas, no tiene vida.");
        }
    }
}
/*

 */

/*
Problema02:En un restaurant se tiene diferentes tipos de menú para ofrecer a 
los clientes. Una cuenta por pagar está compuesta por características como: 
nombre del cliente, listado de todos las cartas(menú) solicitados por el 
cliente, valor a cancelar total, subtotal, Iva.
Los tipos de menú del restaurant son:
Menú a la carta
nombre del plato
valor del menú
valor inicial del menú
valor de porción de guarnición
valor de bebida
porcentaje adicional por servicio en relación del valor inicial del menú
Menú del día
nombre del plato
valor del menú
valor inicial del menú
valor de postre
valor de bebida
Menú de niños
nombre del plato
valor del menú
valor inicial del menú
valor de porción de helado
valor de porción de pastel
Menú económico
nombre del plato
valor del menú
valor inicial del menú
porcentaje de descuento, en referencia al valor inicial del menú
Note
Para solucionar lo anterior se debe generar lo siguiente:
Un diagrama exclusivo que involucren las clases de tipo Menú (usar polimorfismo)
Una solución en lenguaje de programación Java. Usar Polimorfismo en la solución.
Hacer uso del método toString() para presentar toda la información posible del 
objeto (nombre del cliente, subtotal, iva, listado de todos los menú, valor a 
cancelar a total.
@autor: Ariel Torres
@version: 1.0
 */
abstract class Menu {

    protected String nombrePlato;
    protected double valorMenu;

    public Menu(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public abstract void calcularMenu();

    public double getValorMenu() {
        return valorMenu;
    }

    @Override
    public String toString() {
        return "Plato: " + nombrePlato
                + "\nValor menu: $" + valorMenu;
    }

}

class MenuCarta extends Menu {

    private double valorInicial;
    private double guarnicion;
    private double bebida;
    private double porcentajeServicio;

    public MenuCarta(String nombrePlato, double valorInicial,
            double guarnicion, double bebida,
            double porcentajeServicio) {
        super(nombrePlato);
        this.valorInicial = valorInicial;
        this.guarnicion = guarnicion;
        this.bebida = bebida;
        this.porcentajeServicio = porcentajeServicio;
        calcularMenu();
    }

    @Override
    public void calcularMenu() {
        valorMenu = valorInicial + guarnicion + bebida + (valorInicial * porcentajeServicio / 100);
    }

    @Override
    public String toString() {

        return "\nMENU A LA CARTA\n"
                + super.toString();

    }
}

class MenuDia extends Menu {

    private double valorInicial;
    private double postre;
    private double bebida;

    public MenuDia(String nombrePlato, double valorInicial, double postre, double bebida) {
        super(nombrePlato);
        this.valorInicial = valorInicial;
        this.postre = postre;
        this.bebida = bebida;
        calcularMenu();

    }

    @Override
    public void calcularMenu() {

        valorMenu = valorInicial + postre + bebida;

    }

    @Override
    public String toString() {

        return "\nMENU DEL DIA\n"
                + super.toString();

    }
}

class MenuNinos extends Menu {

    private double valorInicial;
    private double helado;
    private double pastel;

    public MenuNinos(String nombrePlato,
            double valorInicial,
            double helado,
            double pastel) {

        super(nombrePlato);

        this.valorInicial = valorInicial;
        this.helado = helado;
        this.pastel = pastel;

        calcularMenu();

    }

    @Override
    public void calcularMenu() {

        valorMenu = valorInicial + helado + pastel;

    }

    @Override
    public String toString() {

        return "\nMENU NINOS\n"
                + super.toString();

    }

}

class MenuEconomico extends Menu {

    private double valorInicial;
    private double descuento;

    public MenuEconomico(String nombrePlato,
            double valorInicial,
            double descuento) {

        super(nombrePlato);

        this.valorInicial = valorInicial;
        this.descuento = descuento;

        calcularMenu();

    }

    @Override
    public void calcularMenu() {

        valorMenu = valorInicial
                - (valorInicial * descuento / 100);

    }

    @Override
    public String toString() {

        return "\nMENU ECONOMICO\n"
                + super.toString();

    }
}

class Cuenta {

    private String nombreCliente;
    private Menu[] menus;

    private double subtotal;
    private double iva;
    private double total;

    public Cuenta(String nombreCliente, Menu[] menus) {

        this.nombreCliente = nombreCliente;
        this.menus = menus;
        calcularCuenta();

    }

    public void calcularCuenta() {
        subtotal = 0;
        for (Menu m : menus) {
            subtotal += m.getValorMenu();
        }
        iva = subtotal * 15/100;
        total = subtotal + iva;

    }

    @Override
    public String toString() {
        String cadena = "";
        for (Menu m : menus) {
            cadena += m + "\n";
        }

        return "CLIENTE: " + nombreCliente + "\n\nLISTADO DE MENUS\n" + cadena
                + "\nSubtotal: $" + subtotal + "\nIVA: $" + iva + "\nTOTAL: $" + total;

    }

}

public class Problema_02_EjecutorGestionMenu {

    public static void main(String[] args) {
        Menu[] menus = new Menu[4];
        menus[0] = new MenuCarta("Lomo fino", 12, 2, 1.5, 10);
        menus[1] = new MenuDia("Seco de pollo", 5, 1, 0.75);
        menus[2] = new MenuNinos("Nuggets", 4, 1, 1.5);
        menus[3] = new MenuEconomico("Arroz con pollo", 6, 15);
        Cuenta cuenta = new Cuenta("Juan Perez", menus);
        System.out.println(cuenta);
    }
}
/*
run:
CLIENTE: Juan Perez

LISTADO DE MENUS

MENU A LA CARTA
Plato: Lomo fino
Valor menu: $16.7

MENU DEL DIA
Plato: Seco de pollo
Valor menu: $6.75

MENU NINOS
Plato: Nuggets
Valor menu: $6.5

MENU ECONOMICO
Plato: Arroz con pollo
Valor menu: $5.1

Subtotal: $35.05
IVA: $5.2575
TOTAL: $40.3075
 */

package ies.alandalus.org.cuatroenraya.modelo;

public class Jugador {
    private final String nombre;
    private final ColorFicha colorFicha;

    public Jugador(String nombre, ColorFicha colorFicha) {
        this.nombre = nombre;
        this.colorFicha = colorFicha;
    }

    public String getNombre() {
        return nombre;
    }

    public char getSimboloFicha() {
        return colorFicha.getSimbolo();
    }

    @Override
    public String toString() {
        return "Jugador: " + nombre + ", Ficha: " + colorFicha;
    }
}

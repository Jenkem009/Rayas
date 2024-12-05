package ies.alandalus.org.cuatroenraya.modelo;

public enum ColorFicha {
    ROJO('R'),
    AMARILLO('A'),
    VERDE('V'),
    AZUL('B');

    private final char simbolo;

    ColorFicha(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }

    @Override
    public String toString() {
        return String.valueOf(simbolo);
    }
}

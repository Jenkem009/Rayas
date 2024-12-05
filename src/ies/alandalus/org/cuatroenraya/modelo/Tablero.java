package ies.alandalus.org.cuatroenraya.modelo;

import ies.alandalus.org.cuatroenraya.modelo.PosicionFicha;

public class Tablero {
    private final char[][] tablero;
    private static final int FILAS = PosicionFicha.values().length; // Número de filas según el enum
    private static final int COLUMNAS = 7;
    private static final char VACIO = '-';

    public Tablero() {
        tablero = new char[FILAS][COLUMNAS];
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = VACIO;
            }
        }
    }

    public boolean colocarFicha(int columna, char ficha) {
        if (columna < 0 || columna >= COLUMNAS) {
            throw new IllegalArgumentException("Columna fuera de rango.");
        }
        for (int i = FILAS - 1; i >= 0; i--) {
            if (tablero[i][columna] == VACIO) {
                tablero[i][columna] = ficha;
                System.out.println("Ficha colocada en " + PosicionFicha.values()[i] + ", Columna " + (columna + 1));
                return true;
            }
        }
        return false; // Columna llena
    }

    public void mostrarTablero() {
        for (char[] fila : tablero) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }

    public boolean tableroLleno() {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                if (tablero[fila][columna] == '-') {
                    return false; // Hay al menos una casilla vacía
                }
            }
        }
        return true; // Todas las casillas están llenas
    }


    public boolean comprobarVictoria(char ficha) {
        // Comprobar horizontal
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna <= COLUMNAS - 4; columna++) {
                if (tablero[fila][columna] == ficha &&
                        tablero[fila][columna + 1] == ficha &&
                        tablero[fila][columna + 2] == ficha &&
                        tablero[fila][columna + 3] == ficha) {
                    return true;
                }
            }
        }

        // Comprobar vertical
        for (int columna = 0; columna < COLUMNAS; columna++) {
            for (int fila = 0; fila <= FILAS - 4; fila++) {
                if (tablero[fila][columna] == ficha &&
                        tablero[fila + 1][columna] == ficha &&
                        tablero[fila + 2][columna] == ficha &&
                        tablero[fila + 3][columna] == ficha) {
                    return true;
                }
            }
        }

        // Comprobar diagonal hacia abajo (\)
        for (int fila = 0; fila <= FILAS - 4; fila++) {
            for (int columna = 0; columna <= COLUMNAS - 4; columna++) {
                if (tablero[fila][columna] == ficha &&
                        tablero[fila + 1][columna + 1] == ficha &&
                        tablero[fila + 2][columna + 2] == ficha &&
                        tablero[fila + 3][columna + 3] == ficha) {
                    return true;
                }
            }
        }

        // Comprobar diagonal hacia arriba (/)
        for (int fila = 3; fila < FILAS; fila++) {
            for (int columna = 0; columna <= COLUMNAS - 4; columna++) {
                if (tablero[fila][columna] == ficha &&
                        tablero[fila - 1][columna + 1] == ficha &&
                        tablero[fila - 2][columna + 2] == ficha &&
                        tablero[fila - 3][columna + 3] == ficha) {
                    return true;
                }
            }
        }

        // Si no se encuentra una victoria
        return false;
    }






}

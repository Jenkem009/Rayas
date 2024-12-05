package ies.alandalus.org.cuatroenraya.modelo;

import java.util.Scanner;

public class Juego {
    private final Tablero tablero;
    private final Jugador jugador1;
    private final Jugador jugador2;

    public Juego(Jugador jugador1, Jugador jugador2) {
        this.tablero = new Tablero();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean turnoJugador1 = true;
        boolean victoria = false;

        while (!tablero.tableroLleno() && !victoria) {
            tablero.mostrarTablero();
            Jugador jugadorActual = turnoJugador1 ? jugador1 : jugador2;

            System.out.println(jugadorActual.getNombre() + ", elige una columna (0-6): ");
            int columna;
            try {
                columna = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada no válida. Intenta de nuevo.");
                scanner.next(); // Limpiar el buffer
                continue;
            }

            if (!tablero.colocarFicha(columna, jugadorActual.getSimboloFicha())) {
                System.out.println("Columna llena o inválida. Intenta de nuevo.");
                continue;
            }

            victoria = tablero.comprobarVictoria(jugadorActual.getSimboloFicha());
            if (victoria) {
                System.out.println("¡" + jugadorActual.getNombre() + " ha ganado!");
            }

            turnoJugador1 = !turnoJugador1;
        }

        if (!victoria) {
            System.out.println("¡El tablero está lleno! Es un empate.");
        }

        tablero.mostrarTablero();
    }
}

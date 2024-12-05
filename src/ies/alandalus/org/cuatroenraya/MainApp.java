package ies.alandalus.org.cuatroenraya;
import ies.alandalus.org.cuatroenraya.modelo.ColorFicha;
import ies.alandalus.org.cuatroenraya.modelo.Juego;
import ies.alandalus.org.cuatroenraya.modelo.Jugador;
import ies.alandalus.org.cuatroenraya.modelo.PosicionFicha;
import ies.alandalus.org.cuatroenraya.modelo.Tablero;
import ies.alandalus.org.cuatroenraya.Consola;
public class MainApp {
    public static void main(String[] args) {
        Consola consola = new Consola();
        Tablero tablero = new Tablero();
        Jugador jugador1 = null;
        Jugador jugador2 = null;
        Juego juego = null;

        while (true) {
            consola.mostrarMenu();
            int opcion = consola.elegirOpcionMenu();

            switch (opcion) {
                case 1 -> {
                    // Crear jugadores
                    String nombre1 = consola.pedirNombreJugador(1);
                    ColorFicha color1 = consola.elegirColorFicha(nombre1);

                    String nombre2 = consola.pedirNombreJugador(2);
                    ColorFicha color2;
                    do {
                        color2 = consola.elegirColorFicha(nombre2);
                        if (color2 == color1) {
                            System.out.println("El color ya está elegido por el jugador 1. Elige otro.");
                        }
                    } while (color2 == color1);

                    jugador1 = new Jugador(nombre1, color1);
                    jugador2 = new Jugador(nombre2, color2);

                    juego = new Juego(jugador1, jugador2);
                    System.out.println("¡Juego creado con éxito!");
                }
                case 2 -> {
                    if (juego == null) {
                        System.out.println("Primero debes crear un juego.");
                    } else {
                        juego.iniciar();
                    }
                }
                case 3 -> {
                    if (tablero != null) {
                        tablero.mostrarTablero();
                    } else {
                        System.out.println("El tablero no está inicializado.");
                    }
                }
                case 4 -> {
                    consola.despedirse();
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}

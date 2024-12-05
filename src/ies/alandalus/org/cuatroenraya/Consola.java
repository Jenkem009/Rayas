package ies.alandalus.org.cuatroenraya;

import ies.alandalus.org.cuatroenraya.modelo.ColorFicha;

import java.util.Scanner;

public class Consola {
    private final Scanner scanner;

    public Consola() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("======== 4 EN RAYA ========");
        System.out.println("1. Crear nuevo juego");
        System.out.println("2. Jugar");
        System.out.println("3. Mostrar tablero");
        System.out.println("4. Salir");
        System.out.println("===========================");
    }

    public int elegirOpcionMenu() {
        int opcion;
        while (true) {
            System.out.print("Elige una opción del menú: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion >= 1 && opcion <= 4) {
                    return opcion;
                } else {
                    System.out.println("Por favor, elige una opción válida (1-4).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intenta nuevamente.");
            }
        }
    }

    public String pedirNombreJugador(int numeroJugador) {
        System.out.print("Introduce el nombre del jugador " + numeroJugador + ": ");
        return scanner.nextLine();
    }

    public ColorFicha elegirColorFicha(String nombreJugador) {
        System.out.println(nombreJugador + ", elige un color para tu ficha:");
        for (ColorFicha color : ColorFicha.values()) {
            System.out.println(color.ordinal() + " - " + color);
        }

        int opcion;
        while (true) {
            System.out.print("Elige una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                return ColorFicha.values()[opcion];
            } catch (Exception e) {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }

    public int elegirColumna() {
        System.out.print("Elige una columna (0-6): ");
        while (true) {
            try {
                int columna = Integer.parseInt(scanner.nextLine());
                if (columna >= 0 && columna <= 6) {
                    return columna;
                } else {
                    System.out.println("La columna debe estar entre 0 y 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intenta nuevamente.");
            }
        }
    }

    public void despedirse() {
        System.out.println("Gracias por jugar a 4 en Raya. ¡Hasta luego!");
    }
}

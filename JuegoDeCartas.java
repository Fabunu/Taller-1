import java.util.Random;
import java.util.Scanner;

public class JuegoDeCartas {
    public static main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("Menu principal");
            System.out.println("1. Iniciar el juego");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opcion");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: 
                    jugar();
                    break;
                case 2: 
                    salir();
                    break;
                default
                    System.out.println("Opcion no valida, ingrese nuevamente:");
            }

        } while(opcion =! 2);
    }

    public static String[][] crearMatrizCartas(){
        String matrizCartas[][] = new String [4][12];
        inicializarCartasJuego(matrizCartas);
        return matrizCartas;

    }

    public static String[][] inicializarCartasJuego(String matrizCartas[][]) {
        
        String palos[] = {"Corazon","Pica","Diamante","Trebol"};
        String valores[] = {"A","2","3","4","5","6","7","8","9","J","Q","K"};
        String puntos[] = {"11","2","3","4","5","6","7","8","9","10","10","10"};

        for(int i = 0; i < palos.length; i++) {
            for(int j = 0; i < valores.length; i++) {
                matrizCartas[i][j] = valores[j] + "de" + palos[i] + "puntos" + puntos[j] ;
            }
        }
    }

    public static int obtenerCarta(String matrizCartas[][]) {
        Random random = new Random();
        int palo = random.nextInt(4);
        int valor = random.nextInt(12);

        String carta = matrizCartas[palo][valor];
        System.out.println("Carta obtenida" + carta);

        String partesCarta[] = carta.split("");
        int puntos = Integer.parseInt(partesCarta[partesCarta.length-2]);
        return puntos;
    }

    public static void jugar(){
        String matrizCartas[][] = crearMatrizCartas();
        Scanner scanner = new Scanner(System.in);
        int puntajeJugador1 = 0;
        int puntajeJugador2 = 0;

        System.out.println("Turno del Jugador 1");
        for (int i = 0; i < 3; i++) {
            puntajeJugador1 += obtenerCarta(matrizCartas);
            System.out.println("Puntaje total del Jugador 1: " + puntajeJugador1);
            if (puntajeJugador1 > 20) {
                System.out.println("¡Jugador 1 se ha pasado de 20 puntos!");
                break;
            }   
        }
        
        System.out.println("Turno del Jugador 2");
        for (int i = 0; i < 3; i++) {
            puntajeJugador2 += obtenerCarta(matrizCartas);
            System.out.println("Puntaje total del Jugador 2: " + puntajeJugador1);
            if (puntajeJugador2 > 20) {
                System.out.println("¡Jugador 2 se ha pasado de 20 puntos!");
                break;
            }   
        }

        if (puntajeJugador1 == 20) {
            System.out.println("Jugador 1 gana con  20 puntos!");
        } else if (puntajeJugador2 == 20) {
            System.out.println("Jugador 2 gana con puntos!");
        } else if (puntajeJugador1 > 20 && puntajeJugador2 > 20) {
            System.out.println("Ambos jugadores se pasaron de 20 puntos. No hay ganador.");
        } else if (puntajeJugador1 <= 20 && (puntajeJugador2 > 20 || puntajeJugador1 > puntajeJugador2)) {
            System.out.println("Jugador 1 gana por estar más cerca de 20 puntos!");
        } else if (puntajeJugador2 <= 20 && (puntajeJugador1 > 20 || puntajeJugador2 > puntajeJugador1)) {
            System.out.println("Jugador 2 gana por estar más cerca de 20 puntos!");
        } else {
            System.out.println("Empate.");
        }
    }
    public static void salir() {
        System.out.println("Gracias por jugar. ¡Hasta pronto!");
    }
}
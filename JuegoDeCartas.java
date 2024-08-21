import java.util.Random;
import java.util.Scanner;

public class JuegoDeCartas {
    public static main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner.scanner = new scanner(System.in);
        int opcion;
        do{
            System.out.println("Menu principal");
            System.out.println("1. Iniciar el juego");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opcion");

            opcion = scanner.nextInt();

            switch(opcion) {
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

    public static int obtenerCartas(String matrizCartas[][]) {
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
        
    }
}
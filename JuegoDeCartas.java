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
    
}
import java.util.Scanner;
import java.io.IOException;

public class MenuConCLS {

    public static void menu(){
        System.out.println("MENU PRINCIPAL");
        System.out.println("Elige una opcion");
        System.out.println("1) Opcion 1");
        System.out.println("2) Opcion 2");
        System.out.println("3) Opcion 3");
        System.out.println("4) Opcion 4");
        System.out.println("5) Salir");
    } // fin del metodo menu

    public static void main(String[] args) throws IOException, InterruptedException {
        int opcion;
        Scanner entrada = new Scanner(System.in);

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear Screen (clc)

        do {
            menu();
            opcion = entrada.nextInt();
            if (opcion == 5){
                System.out.println("Adios :-)");
                break;
            }
            System.out.println("Eligiste la opcion "+ opcion);
            System.out.println(" ");
            System.out.println("Teclea \"c\" y luego presiona la tecla [Enter] para continuar... ");
            entrada.next().charAt(0);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // Clear Screen (clc)
        } while (opcion !=5); // fin del while
    } // fin del main
} //fin del Clase

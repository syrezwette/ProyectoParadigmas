package co.poli.edu.sistemaGestionTareas.vista;

import java.util.Scanner;


public class Principal {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int menuBusqueda;

        do {
            System.out.println("¿Qué operación deseas hacer?");
            System.out.println("1. create");
            System.out.println("2. read");
            System.out.println("3. update");
            System.out.println("4. delete");
            System.out.println("5. serializar");
            System.out.println("6. deserializar");
            System.out.println("7. Salir");

            menuBusqueda = Integer.parseInt(teclado.nextLine());

            switch (menuBusqueda) {
                case 1:
                    
                    System.out.println("Realizando operación create...");
                    break;
                case 2:
                
                    System.out.println("Realizando operación read...");
                    break;
                case 3:
                    
                    System.out.println("Realizando operación update...");
                    break;
                case 4:
                  
                    System.out.println("Realizando operación delete...");
                    break;
                case 5:
                
                    System.out.println("Realizando operación serializar...");
                    break;
                case 6:
                  
                    System.out.println("Realizando operación deserializar...");
                    break;
     
                    
                default:
                    System.out.println("Ingresa una opción válida en el menú: 1-7");
                    return;
            }
        } while (menuBusqueda != 6);
    }
}


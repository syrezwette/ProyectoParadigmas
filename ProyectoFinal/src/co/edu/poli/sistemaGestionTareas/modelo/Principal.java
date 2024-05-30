package co.edu.poli.sistemaGestionTareas.modelo;

import java.util.Scanner;

import co.edu.poli.sistemaGestionTareas.servicios.*;

public class Principal {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
        ImpleOperacion imple = new ImpleOperacion();
        ImplementacionOperacion Imp2 = new ImplementacionOperacion();

        System.out.println("¿Qué operación deseas hacer?");
        System.out.println("1. create");
        System.out.println("2. read");
        System.out.println("3. update");
        System.out.println("4. delete");
        System.out.println("5. serializar");
        System.out.println("6. deserializar");

        int menu = Integer.parseInt(teclado.nextLine());// Consumir el salto de línea pendiente

        do {

            switch (menu) {

                case 1:

                    System.out.println("Seleccione el tipo de usuario que desea ingresar:\n1. Profesor \n2. Estudiante");
                    int a=teclado.nextInt();
                    teclado.nextLine();

                    if (a == 1) {
                        System.out.println("Ingrese su número de identificación:");
                        int id = Integer.parseInt(teclado.nextLine());

                        System.out.println("Ingrese su nombre de usuario:");
                        String nombreUsuario = teclado.nextLine();

                        System.out.println("Ingrese su email:");
                        String email = teclado.nextLine();

                        System.out.println("Ingrese su contraseña:");
                        String contrasenia = teclado.nextLine();

                        System.out.println("Ingrese la materia que dicta:");
                        String materia = teclado.nextLine();

                        Profesor primero = new Profesor(id, nombreUsuario, email, contrasenia, materia);
                        
                        System.out.println(imple.create(primero));
                        
                    } else if (a == 2) {
                        System.out.println("Ingrese su número de identificación:");
                        int id = Integer.parseInt(teclado.nextLine());

                        System.out.println("Ingrese su nombre de usuario:");
                        String nombreUsuario = teclado.nextLine();

                        System.out.println("Ingrese su email:");
                        String email = teclado.nextLine();

                        System.out.println("Ingrese su contraseña:");
                        String contrasenia = teclado.nextLine();

                        System.out.println("Ingrese la materia que está viendo:");
                        String materia = teclado.nextLine();

                        Estudiante primero = new Estudiante(id, nombreUsuario, email, contrasenia, materia);
                        System.out.println(imple.create(primero));
                    } else {
                        System.out.println("El número ingresado es incorrecto");
                    }

                    break;

                case 2:

                    System.out.println("Escriba su número de identificación:");
                    String id1 = teclado.nextLine();
                    System.out.println("Estos son sus datos:");
                    System.out.println(imple.read(id1));

                    break;

                case 3:

                    System.out.println("Escriba su número de identificación:");
                    @SuppressWarnings("unused")
                    String sr = teclado.nextLine();
                    

                    System.out.println("Seleccione el tipo de usuario a actualizar:\n1. Profesor \n2. Estudiante");
                    int b = Integer.parseInt(teclado.nextLine());

                    if (b == 1) {
                        System.out.println("Ingrese su número de identificación:");
                        int id = Integer.parseInt(teclado.nextLine());

                        System.out.println("Ingrese su nombre de usuario:");
                        String nombreUsuario = teclado.nextLine();

                        System.out.println("Ingrese su email:");
                        String email = teclado.nextLine();

                        System.out.println("Ingrese su contraseña:");
                        String contrasenia = teclado.nextLine();

                        System.out.println("Ingrese la materia que está viendo:");
                        String materia = teclado.nextLine();

                        Profesor primero = new Profesor(id, nombreUsuario, email, contrasenia, materia);
                        System.out.println(imple.update(id, primero));
                    } else if (b == 2) {
                        System.out.println("Ingrese su número de identificación:");
                        int id = Integer.parseInt(teclado.nextLine());

                        System.out.println("Ingrese su nombre de usuario:");
                        String nombreUsuario = teclado.nextLine();

                        System.out.println("Ingrese su email:");
                        String email = teclado.nextLine();

                        System.out.println("Ingrese su contraseña:");
                        String contrasenia = teclado.nextLine();

                        System.out.println("Ingrese la materia que está viendo:");
                        String materia = teclado.nextLine();

                        Estudiante primero = new Estudiante(id, nombreUsuario, email, contrasenia, materia);
                        System.out.println(imple.create(primero));
                    } else {
                        System.out.println("El número ingresado es incorrecto");
                    }

                    break;

                case 4:

                    System.out.println("Escriba su número de identificación:");
                    String ud = teclado.nextLine();

                    System.out.println(imple.delete(ud));

                    break;

                case 5:
                	
                	Imp2.serializar(imple.getarreglo(), "", "Codigo8");
                	System.out.println("Su archivo se guardó correctamente");

                    break;

                case 6:
                    Usuario[] us = Imp2.Deserializar("", "Codigo8");

                    if (us != null) { // Verificar si us no es null antes de iterar sobre él
                        for (int i = 0; i < us.length; i++) {
                            System.out.println(us[i]);
                        }
                    } else {
                        System.out.println("El arreglo de usuarios obtenido de la deserialización es nulo.");
                    }

                 

                    break;

            }

            System.out.println("¿Qué operación deseas hacer?");
            System.out.println("1. create");
            System.out.println("2. read");
            System.out.println("3. update");
            System.out.println("4. delete");
            System.out.println("5. serializar");
            System.out.println("6. deserializar");

            menu = Integer.parseInt(teclado.nextLine());

        } while (menu != 8);

    }

}
  
			
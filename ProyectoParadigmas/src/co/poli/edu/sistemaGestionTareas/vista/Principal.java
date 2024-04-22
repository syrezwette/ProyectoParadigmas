package co.poli.edu.sistemaGestionTareas.vista;

import java.util.Scanner;

import co.poli.edu.sistemaGestionTareas.modelo.*;
import co.poli.edu.sistemaGestionTareas.servicios.*;

public class Principal {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		ImpleOperacion imple = new ImpleOperacion();
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

				System.out.println("seleccione el usuario que deseea ingresar :\n1. Profesor \n2. Estudiante");
				int a = teclado.nextInt();
				teclado.nextLine();
				if (a == 1) {
					System.out.println("su numero de idetificacion");
					int id = Integer.parseInt(teclado.nextLine());

					System.out.println("diga su nombre de usuario");
					String nombreUsuario = teclado.nextLine();

					System.out.println("su email");
					String email = teclado.nextLine();

					System.out.println("su contraseña");
					String contrasenia = teclado.nextLine();

					System.out.println("materia que dicta");
					String materia = teclado.nextLine();
					Profesor primero = new Profesor(id, nombreUsuario, email, contrasenia, materia);

				} else if (a == 2) {
					System.out.println("su numero de idetificacion");
					int id = Integer.parseInt(teclado.nextLine());

					System.out.println("diga su nombre de usuario");
					String nombreUsuario = teclado.nextLine();

					System.out.println("su email");
					String email = teclado.nextLine();

					System.out.println("su contraseña");
					String contrasenia = teclado.nextLine();

					System.out.println("materia que esta viendo");
					String materia = teclado.nextLine();
					Estudiante primero = new Estudiante(id, nombreUsuario, email, contrasenia, materia);
					System.out.println(imple.create(primero));

				} else {
					System.out.println(
							"para continuar debes de ser profesor o estudiante, por favor selecciona uno de los dos.");

				}
				break;
			case 2:
				System.out.println("dame el id de tu usuario para leerlo: ");
				String imprimir = teclado.nextLine();
				System.out.println(imple.read(imprimir));

				break;
			case 3:
				System.out.println("Ingrese el ID del usuario que desea actualizar: ");
				int idUsuarioActualizar = Integer.parseInt(teclado.nextLine());

				System.out.println("Ingrese el nuevo nombre de usuario:");
				String nuevoNombreUsuario = teclado.nextLine();
				System.out.println("Ingrese el nuevo email:");
				String nuevoEmail = teclado.nextLine();
				System.out.println("Ingrese la nueva contraseña:");
				String nuevaContraseña = teclado.nextLine();

				Usuario usuarioActualizado = new Usuario(idUsuarioActualizar, nuevoNombreUsuario, nuevoEmail,
						nuevaContraseña);

				System.out.println(imple.update(idUsuarioActualizar, usuarioActualizado));
				System.out.println(usuarioActualizado);
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

package ar.edu.unju.fi.ejercicio4.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int opcion = 0;
		try {
			do {
				System.out.println("=======================");
				System.out.println("1 - Crear jugador");
				System.out.println("2 - Mostrar jugadores");
				System.out.println("3 - Modificar posicion de jugador");
				System.out.println("4 - Eliminar jugador");
				System.out.println("5 - Salir");
				System.out.println("=======================");
				
				opcion = scanner.nextInt();
				scanner.nextLine();
				
				switch (opcion) {
					case 1: System.out.println("Opcion 1");
						break;
					case 2: System.out.println("Opcion 2");
						break;
					case 3: System.out.println("Opcion 3");
						break;
					case 4: System.out.println("Opcion 4");
						break;
					case 5: System.out.println("Fin del programa...");
						break;
					default:
						System.out.println("Opcion no válida");
						break;
				}
			} while(opcion != 5);
		} catch (InputMismatchException ex) {
			System.out.println("Por favor ingrese numeros...");
		}
	}
}

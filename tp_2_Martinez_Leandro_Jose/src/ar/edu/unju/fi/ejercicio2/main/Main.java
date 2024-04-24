package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	private static Scanner scanner;
	private static List<Efemeride> efemerides;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		efemerides = new ArrayList<>();
		
		int option = 0;
		do {
			System.out.println("------------------------------");
			System.out.println("1 - Crear efeméride");
			System.out.println("2 - Mostrar efemérides");
			System.out.println("3 - Eliminar efeméride");
			System.out.println("4 - Modificar efeméride");
			System.out.println("5 - Salir");
			System.out.println("------------------------------");
			
			option = scanner.nextInt();
			scanner.nextLine();
			
			switch (option) {
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
				System.out.println("Error. Intente nuevamente");
				break;
			}
		} while(option != 5);
	}

}

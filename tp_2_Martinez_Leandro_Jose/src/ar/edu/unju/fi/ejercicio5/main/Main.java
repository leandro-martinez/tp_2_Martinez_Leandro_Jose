package ar.edu.unju.fi.ejercicio5.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {
	private static Scanner scanner;
	private static List<Producto> productos;
	
	public static void main(String[] args) {
		productos = new ArrayList<>();
		scanner = new Scanner(System.in);
		int opcion = 0;
		
		try {
			do {
				System.out.println("1 - Mostrar productos");
				System.out.println("2 - Realizar compra");
				System.out.println("3 - Salir");
				
				opcion = scanner.nextInt();
				scanner.nextLine();
				
				switch(opcion) {
					case 1: System.out.println("Opcion 1");
						break;
					case 2: System.out.println("Opcion 2");
						break;
					case 3: System.out.println("Fin del programa...");
						break;
					default: System.out.println("Opcion no válida");
						break;
				}
				
			} while(opcion != 3);
		} catch (InputMismatchException ex) {
			System.out.println("Por favor ingrese números.");
		}
	}

}

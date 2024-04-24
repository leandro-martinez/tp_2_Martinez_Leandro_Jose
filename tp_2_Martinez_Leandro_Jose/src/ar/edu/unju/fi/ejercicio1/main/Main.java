package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {
	private static Scanner scanner;
	private static List<Producto> productos;
	
	public static void main(String[] args) {
		 scanner = new Scanner(System.in);
		 productos = new ArrayList<>();
		 int option = 0;
		 
		 do {
			 System.out.println("------------------------");
			 System.out.println("1 - Crear Producto");
			 System.out.println("2 - Mostrar Productos");
			 System.out.println("3 - Modificar Producto");
			 System.out.println("4 - Salir");
			 System.out.println("------------------------");
			 
			 option = scanner.nextInt();
			 scanner.nextLine();
			 
			 switch (option) {
			 	case 1: crearProducto();
			 		break;
			 	case 2: System.out.println("opcion 2");
			 		break;
			 	case 3: System.out.println("opcion 3");
			 		break;
			 	case 4: System.out.println("Fin del programa...");
			 	 	break;
			 	default:
			 		System.out.println("Opcion incorrecta. Intente nuevamente...");
			 		break;
			 }
		 } while(option != 4);
		 
		 
	}
	
	public static void crearProducto () {
		int opcion = 0;
		do {
			System.out.println("---- Origen de Fabricación ----");
			System.out.println("1 - Argentina");
			System.out.println("2 - China");
			System.out.println("3 - Brasil");
			System.out.println("4 - Uruguay");
			System.out.println("Elija una opcion: ");
			
			if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion < 1 || opcion > 4) {
                    System.out.println("Opción no válida. Intente nuevamente...");
                }
            } else {
                scanner.nextLine();
                System.out.println("Opción no válida. Intente nuevamente...");
            }
		} while(opcion < 1 || opcion > 4);
		
		int opcion_dos = 0;
		do {
			System.out.println("---- Categoria ----");
			System.out.println("1 - Telefonía");
			System.out.println("2 - Informática");
			System.out.println("3 - Electro hogar");
			System.out.println("4 - Herramientas");
			System.out.println("Elija una opcion: ");
			
			if (scanner.hasNextInt()) {
                opcion_dos = scanner.nextInt();
                scanner.nextLine();
                if (opcion_dos < 1 || opcion_dos > 4) {
                    System.out.println("Opción no válida. Intente nuevamente...");
                }
            } else {
                scanner.nextLine();
                System.out.println("Opción no válida. Intente nuevamente...");
            }
		} while(opcion_dos < 1 || opcion_dos > 4);
		System.out.println("opcion elegida: "+ opcion_dos);
	}
}

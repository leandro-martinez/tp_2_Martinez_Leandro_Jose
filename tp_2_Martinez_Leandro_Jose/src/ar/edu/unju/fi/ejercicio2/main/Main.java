package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.model.Efemeride;
import ar.edu.unju.fi.ejercicio3.constantes.Mes;

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
			case 1: crearEfemeride();
				break;
			case 2: mostrarEfemerides();
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
	public static void mostrarEfemerides () {
		if(efemerides.isEmpty()) {
			System.out.println("Lista vacía...");
		} else {
			System.out.println("---- Lista de Efemerides ----");
			efemerides.forEach(i -> System.out.println(i));
		}
	}
	public static void crearEfemeride () {
		Efemeride efemeride = new Efemeride();
		
		System.out.println("Ingrese el código del efemeride: ");
		efemeride.setCodigo(scanner.nextLine());
		
		int numero_mes = 0;
		do {
			System.out.println("Ingrese el mes en tipo de dato numerico [1 al 12]: ");
			if (scanner.hasNextInt()) {
	            numero_mes = scanner.nextInt();
	            scanner.nextLine();
	            if (numero_mes < 1 || numero_mes > 12) {
	                System.out.println("Opción no válida. Intente nuevamente...");
	            }
	        } else {
	        	scanner.nextLine();
	        	System.out.println("Opción no válida. Intente nuevamente...");
	        }
		} while (numero_mes < 1 || numero_mes > 12);
		Mes mes = Mes.values()[numero_mes - 1];
		efemeride.setMes(mes);
		
		int numero_dia = 0;
		do {
			System.out.println("Ingrese el dia [1 al 31]: ");
			if (scanner.hasNextInt()) {
	            numero_dia = scanner.nextInt();
	            scanner.nextLine();
	            if (numero_dia < 1 || numero_dia > 31) {
	                System.out.println("Opción no válida. Intente nuevamente...");
	            }
	        } else {
	        	scanner.nextLine();
	        	System.out.println("Opción no válida. Intente nuevamente...");
	        }
		} while(numero_dia < 1 || numero_dia > 31);
		efemeride.setDia(numero_dia);
	
		System.out.println("Ingrese el detalle: ");
		efemeride.setDetalle(scanner.nextLine());
		
		efemerides.add(efemeride);
		System.out.println("Efemeride fue creado exitosamente...");
	}
}

package ar.edu.unju.fi.ejercicio7.main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		do {
            System.out.println("------ Menú de opciones ------");
            System.out.println("1 - Mostrar productos activos");
            System.out.println("2 - Mostrar productos inactivos");
            System.out.println("3 - Incrementar precios en un 20%");
            System.out.println("4 - Mostrar productos de Electrohogar disponibles");
            System.out.println("5 - Ordenar productos por precio descendente");
            System.out.println("6 - Mostrar nombres de productos en mayúsculas");
            System.out.println("7 - Salir");
            System.out.println("Ingrese una opción: ");
            
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor ingrese una opción válida (número entero): ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Opcion 1");
                    break;
                case 2:
                	System.out.println("Opcion 2");
                    break;
                case 3:
                	System.out.println("Opcion 3");
                    break;
                case 4:
                	System.out.println("Opcion 4");
                    break;
                case 5:
                	System.out.println("Opcion 5");
                    break;
                case 6:
                	System.out.println("Opcion 6");
                    break;
                case 7:
                    System.out.println("Fin del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 7);
		scanner.close();
	}
}

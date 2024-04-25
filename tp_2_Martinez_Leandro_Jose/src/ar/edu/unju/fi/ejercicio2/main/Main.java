package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Iterator;
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
			case 3: eliminarEfemeride();
				break;
			case 4: modificarEfemeride();
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
		
		Mes mes = validarMes();
		efemeride.setMes(mes);
		
		int dia = validarDia();
		efemeride.setDia(dia);
	
		System.out.println("Ingrese el detalle: ");
		efemeride.setDetalle(scanner.nextLine());
		
		efemerides.add(efemeride);
		System.out.println("Efemeride fue creado exitosamente...");
	}
	public static void eliminarEfemeride () {
		if(efemerides.isEmpty()) {
			System.out.println("Lista vacía...");
		} else {
			System.out.println("Ingrese el código del efemeride a eliminar: ");
			String codigo = scanner.nextLine();
			
			Boolean efemerideFounded = false;
			Iterator<Efemeride> iterator = efemerides.iterator();
			while(iterator.hasNext()) {
				Efemeride efemeride = iterator.next();
				if(efemeride.getCodigo().equalsIgnoreCase(codigo)) {
					efemerideFounded = true;
				  	iterator.remove();
					mostrarEfemerides();
					System.out.println("------------------");
					System.out.println("Se eliminó el efemeride con el codigo: "+ codigo);
				}
			}
			if(!efemerideFounded) {
				System.out.println("No se encontró el efemeride...");
			}
		}
	}
	public static void modificarEfemeride () {
		if(efemerides.isEmpty()) {
			System.out.println("Lista vacía...");
		} else {
			System.out.println("Ingrese el código del efemeride a modificar: ");
			String codigo = scanner.nextLine();
			Efemeride efemerideFounded = null;
			for (Efemeride efemeride : efemerides) {
	        	if (efemeride.getCodigo().equals(codigo)) {
	        		efemerideFounded = efemeride;
	        		break;
	             }
	        }
	        if (efemerideFounded == null) {
	        	System.out.println("Efemeride no encontrado.");
	        } else {
	        	int opcion_modificar = 0;
	        	do {
	        		System.out.println("---- Modificar Efemeride ----");
	                System.out.println("1 - Mes");
	                System.out.println("2 - Dia");
	                System.out.println("3 - Detalle");
	                System.out.println("4 - Salir");
	                System.out.print("Elija una opción: ");
	                
	                opcion_modificar = scanner.nextInt();
	                scanner.nextLine(); 
	                
	                switch (opcion_modificar) {
						case 1: 
							Mes mes = validarMes();
							efemerideFounded.setMes(mes);
							break;
						case 2:
							int dia = validarDia();
							efemerideFounded.setDia(dia);
							break;
						case 3:
							System.out.println("Ingrese un nuevo detalle: ");
							efemerideFounded.setDetalle(scanner.nextLine());
							break;
						case 4: 
							System.out.println("Fin de la modificacion...");
						default:
							System.out.println("Opcion incorrecta. Intente nuevamente...");
							break;
					}
	                
	        	} while(opcion_modificar != 4);
                System.out.println("Efemeride modificado exitosamente...");
	        }
		}
	}
	public static Mes validarMes () {
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
		return mes;
	}
	public static int validarDia () {
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
		return numero_dia;
	}
}

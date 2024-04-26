package ar.edu.unju.fi.ejercicio4.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {
	private static Scanner scanner;
	private static List<Jugador> jugadores;
	
	public static void main(String[] args) {
		jugadores = new ArrayList<>();
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
					case 1: crearJugador();
						break;
					case 2: mostrarJugadores();
						break;
					case 3: modificarJugador();
						break;
					case 4: eliminarJugador();
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
	public static void mostrarJugadores () {
		if(jugadores.isEmpty()) {
			System.out.println("Lista vacia...");
		} else {
			System.out.println("--------- Lista de jugadores ----------");
			jugadores.forEach(jugador -> System.out.println(jugador));
		}
	}
	public static void crearJugador () {
		Jugador jugador = new Jugador();
		Calendar fechaNacimiento = Calendar.getInstance();
		
		System.out.println("Ingrese el nombre del jugador: ");
		jugador.setNombre(scanner.nextLine());
		
		System.out.println("Ingrese el apellido del jugador: ");
		jugador.setApellido(scanner.nextLine());
		
		System.out.println("Ingrese la fecha de nacimiento del jugador (dd/mm/yyyy): ");
		String fechaNacimientoStr = scanner.nextLine();
        String[] fechaParts = fechaNacimientoStr.split("/");
        int day = Integer.parseInt(fechaParts[0]);
        int month = Integer.parseInt(fechaParts[1]) - 1;
        int year = Integer.parseInt(fechaParts[2]);
        fechaNacimiento.set(year, month, day);
        jugador.setFechaDeNacimiento(fechaNacimiento);
        
        System.out.println("Ingrese la nacionalidad del jugador: ");
        jugador.setNacionalidad(scanner.nextLine());
        
        System.out.println("Ingrese la estatura (cm) del jugador: ");
        jugador.setEstatura(scanner.nextInt());
        
        System.out.println("Ingrese el peso del jugador: ");
        jugador.setPeso(scanner.nextDouble());
        
        Posicion poscicion = validarPosicion();
        jugador.setPosicion(poscicion);
        
        jugadores.add(jugador);
        
        System.out.println("Se agregó un nuevo jugador...");
	}
	public static void eliminarJugador() {
		System.out.println("Ingrese el nombre del jugador: ");
		String nombre = scanner.next();
		
		System.out.println("Ingrese el apellido del jugador: ");
		String apellido = scanner.next();
		
		Iterator<Jugador> iterator = jugadores.iterator();
        boolean jugadorEncontrado = false;

        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                iterator.remove();
                System.out.println("Jugador eliminado correctamente.");
                jugadorEncontrado = true;
            }
        }
        if (!jugadorEncontrado) {
        	System.out.println("No se encontró ningún jugador con ese nombre y apellido.");
        }
	}
	public static void modificarJugador() {
		System.out.println("Ingrese el nombre del jugador: ");
		String nombre = scanner.nextLine();
		
		System.out.println("Ingrese el apellido del jugador");
		String apellido = scanner.nextLine();
		
		Jugador jugadorEncontrado = null;
		
		for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equalsIgnoreCase(nombre) &&
                jugador.getApellido().equalsIgnoreCase(apellido)) {
                jugadorEncontrado = jugador;
                break;
            }
        }

        if (jugadorEncontrado != null) {
            // Modificar los datos del jugador
            Posicion nuevaPosicion = validarPosicion();
            
            jugadorEncontrado.setPosicion(nuevaPosicion);
            System.out.println("Se ha modificado el jugador correctamente...");
        } else {
        	System.out.println("Jugador no encontrado...");
        }
		
	}
	public static Posicion validarPosicion () {
		int opcion = 0;
		do {
			System.out.println("Ingrese la posicion del jugador: ");
			System.out.println("---- Posicion ----");
			System.out.println("1 - Delantero");
			System.out.println("2 - Medio");
			System.out.println("3 - Defensa");
			System.out.println("4 - Arquero");
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
		
		Posicion posicion = 
				Posicion.values()[opcion - 1];
		return posicion;
	}
}

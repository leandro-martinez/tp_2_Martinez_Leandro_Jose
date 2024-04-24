package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;

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
			 	case 2: mostrarProductos();
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
	
	public static void mostrarProductos() {
		if (productos.isEmpty()) {
			System.out.println("Lista de productos vacía...");
		} else {
			System.out.println("---- Lista de productos ----");
			productos.forEach(product -> System.out.println(product));			
		}
	}
	
	public static void crearProducto () {
		Producto producto = new Producto();
		
		System.out.println("Ingrese el código del producto: ");
		producto.setCodigo(scanner.nextLine());
		
		System.out.println("Ingrese la descripción del producto: ");
		producto.setDescripcion(scanner.nextLine());
		
		System.out.println("Ingrese el precio del producto: ");
		double precio = scanner.nextDouble();
		producto.setPrecioUnitario(precio);
		scanner.nextLine();
		
		int origen_fabricacion = 0;
		do {
			System.out.println("---- Origen de Fabricación ----");
			System.out.println("1 - Argentina");
			System.out.println("2 - China");
			System.out.println("3 - Brasil");
			System.out.println("4 - Uruguay");
			System.out.println("Elija una opcion: ");
			
			if (scanner.hasNextInt()) {
                origen_fabricacion = scanner.nextInt();
                scanner.nextLine();
                if (origen_fabricacion < 1 || origen_fabricacion > 4) {
                    System.out.println("Opción no válida. Intente nuevamente...");
                }
            } else {
                scanner.nextLine();
                System.out.println("Opción no válida. Intente nuevamente...");
            }
		} while(origen_fabricacion < 1 || origen_fabricacion > 4);
		
		OrigenFabricacion origenFabricacion = 
				OrigenFabricacion.values()[origen_fabricacion - 1];
		producto.setOrigenFabricacion(origenFabricacion);
		
		int opcion_categoria = 0;
		do {
			System.out.println("---- Categoria ----");
			System.out.println("1 - Telefonía");
			System.out.println("2 - Informática");
			System.out.println("3 - Electro hogar");
			System.out.println("4 - Herramientas");
			System.out.println("Elija una opcion: ");
			
			if (scanner.hasNextInt()) {
                opcion_categoria = scanner.nextInt();
                scanner.nextLine();
                if (opcion_categoria < 1 || opcion_categoria > 4) {
                    System.out.println("Opción no válida. Intente nuevamente...");
                }
            } else {
                scanner.nextLine();
                System.out.println("Opción no válida. Intente nuevamente...");
            }
		} while(opcion_categoria < 1 || opcion_categoria > 4);
		
		Categoria categoria = 
				Categoria.values()[opcion_categoria - 1];
		producto.setCategoria(categoria);
		
		productos.add(producto);
		System.out.println("Producto creado exitosamente...");
	}
}

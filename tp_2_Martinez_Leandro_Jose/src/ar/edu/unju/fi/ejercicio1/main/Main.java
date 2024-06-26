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
			 	case 3: modificarProducto();
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
		
		double precio;
		while (true) {
			System.out.println("Ingrese el precio del producto: ");
		    String input = scanner.nextLine();
		    try {
		    	precio = Double.parseDouble(input);
		        break;
		    } catch (NumberFormatException e) {
		    	System.out.println("Tipo de dato no válido. Intente nuevamente...");
		    }
		 }
		producto.setPrecioUnitario(precio);
		
		OrigenFabricacion origenFabricacion = obtenerOrigenFabricacion();
		producto.setOrigenFabricacion(origenFabricacion);
		
		Categoria categoria = obtenerCategoria();
		producto.setCategoria(categoria);
		
		productos.add(producto);
		System.out.println("Producto creado exitosamente...");
	}
	public static void modificarProducto () {
		if (productos.isEmpty()) {
			 System.out.println("Lista de productos vacía...");
	    } else {
	        System.out.print("Ingrese el código del producto a modificar: ");
	        String codigo = scanner.nextLine();
	        Producto productoFounded = null;
	        for (Producto producto : productos) {
	        	if (producto.getCodigo().equals(codigo)) {
	        		productoFounded = producto;
	        		break;
	             }
	        }
	        if (productoFounded == null) {
	        	System.out.println("Producto no encontrado.");
	        } else {
	        	int opcion_modificar = 0;
	        	do {
	        		System.out.println("---- Modificar Producto ----");
	                System.out.println("1 - Descripción");
	                System.out.println("2 - Precio");
	                System.out.println("3 - Origen de Fabricación");
	                System.out.println("4 - Categoría");
	                System.out.println("5 - Salir");
	                System.out.print("Elija una opción: ");
	                
	                opcion_modificar = scanner.nextInt();
	                scanner.nextLine(); 
	                
	                switch (opcion_modificar) {
						case 1: 
							System.out.println("Ingrese la nueva descripción: ");
							productoFounded.setDescripcion(scanner.nextLine());
							break;
						case 2:
							double precio;
							while (true) {
								System.out.println("Ingrese el precio del producto: ");
							    String input = scanner.nextLine();
							    try {
							    	precio = Double.parseDouble(input);
							        break;
							    } catch (NumberFormatException e) {
							    	System.out.println("Tipo de dato no válido. Intente nuevamente...");
							    }
							 }
							productoFounded.setPrecioUnitario(precio);
							break;
						case 3:
							OrigenFabricacion origen = obtenerOrigenFabricacion();
							productoFounded.setOrigenFabricacion(origen);
							break;
						case 4:
							Categoria categoria = obtenerCategoria();
							productoFounded.setCategoria(categoria);
							break;
						case 5:
							System.out.println("Fin de la modificacion...");
							break;
						default:
							System.out.println("Opcion incorrecta. Intente nuevamente...");
							break;
					}
	                
	        	} while(opcion_modificar != 5);    	
	        	
                System.out.println("Producto modificado exitosamente...");
	        }
	    }
	}
	public static OrigenFabricacion obtenerOrigenFabricacion () {
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
		
		OrigenFabricacion origen = 
				OrigenFabricacion.values()[origen_fabricacion - 1];
		return origen;
	}
	public static Categoria obtenerCategoria () {
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
		return categoria;
	}
}

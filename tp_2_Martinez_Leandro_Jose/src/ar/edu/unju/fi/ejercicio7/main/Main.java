package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.Product;

public class Main {
	private static List<Product> productos;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		precargarProductos();
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
                case 1: mostrarProductos(true);
                    break;
                case 2: mostrarProductos(false);
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
	public static void precargarProductos () {
		if(productos == null) {
			productos = new ArrayList<>();
		}
		for (int i = 1; i <= 15; i++) {
			Boolean estado = true;
			if(i % 2 == 0) {
				estado = false;
			}
			String codigo = "cod" + i;
			String descripcion = "Producto " + i;
			double precio = 10 * i;
			OrigenFabricacion origenFabricacion = OrigenFabricacion.ARGENTINA; 
			Categoria categoria =  Categoria.ELECTROHOGAR;
			productos.add(new Product(codigo, descripcion, precio, origenFabricacion, categoria, estado));
		}
	}
	public static void mostrarProductos(boolean estado) {
		String stock = estado ? "Disponibles" : "Faltantes";
		System.out.println("------ Productos " + stock + " ------");
		for(Product producto: productos) {
			if(producto.getEstado() == estado) {
				System.out.println(producto);
			}
		}
	}
}

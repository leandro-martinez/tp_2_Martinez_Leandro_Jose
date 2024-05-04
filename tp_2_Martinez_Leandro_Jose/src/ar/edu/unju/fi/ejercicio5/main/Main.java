package ar.edu.unju.fi.ejercicio5.main;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.Product;

public class Main {
	private static Scanner scanner;
	private static List<Product> productos;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int opcion = 0;
		precargarProductos();
		try {
			do {
				System.out.println("1 - Mostrar productos");
				System.out.println("2 - Realizar compra");
				System.out.println("3 - Salir");
				
				opcion = scanner.nextInt();
				scanner.nextLine();
				
				switch(opcion) {
					case 1: mostrarProductos();
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
			Categoria categoria =  Categoria.HERRAMIENTAS;
			productos.add(new Product(codigo, descripcion, precio, origenFabricacion, categoria, estado));
		}
	}
	public static void mostrarProductos() {
		System.out.println("------ Productos ------");
		productos.forEach(x -> System.out.println(x));
	}
}

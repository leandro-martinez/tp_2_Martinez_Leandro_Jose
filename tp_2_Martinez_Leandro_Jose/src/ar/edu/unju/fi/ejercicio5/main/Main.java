package ar.edu.unju.fi.ejercicio5.main;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.interfaces.IPago;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Product;

public class Main {
	private static Scanner scanner;
	private static List<Product> productos;
	private static List<Product> carrito;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		carrito = new ArrayList<>();
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
					case 2: realizarCompra();
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
	public static void mostrarCarrito() {
		if(carrito.isEmpty()) {
			System.out.println("------ Carrito vacío ------");
		}else {
			System.out.println("------ Carrito ------");
			carrito.forEach(i -> System.out.println(i));
			System.out.println("---------------------");
		}
	}
	public static double calcularMonto () {
		double monto = 0;
		for (Product producto: carrito) {
			monto += producto.getPrecioUnitario();
		}
		return monto;
	}
	public static void realizarCompra () {
		int opcion = 0;
		do {
			mostrarProductos();
			System.out.println("----------------------------");
			System.out.println("Ingrese el codigo del producto a comprar: ");
			String codigoCompra = scanner.next();
			boolean productFounded = false;
	        for (Product producto : productos) {
	            if (producto.getCodigo().equalsIgnoreCase(codigoCompra) && producto.getEstado() == true) {
	            	productFounded = true;
	            	carrito.add(producto);
	            	producto.setEstado(false);
	                System.out.println("Producto agregado al carrito...");
	            }
	        }
	        if(!productFounded) {
	        	System.out.println("Codigo no valido o producto sin stock...");
	        } else {
	        	mostrarCarrito();
		        System.out.println("1 - Seguir comprando");
		        System.out.println("2 - Terminar compra");
		        System.out.println("Ingrese una opcion: ");
				opcion = scanner.nextInt();
				scanner.nextLine();
	        }
		} while(opcion != 2);
		
		int optPago = 0;
		IPago pago = null;
		double monto = calcularMonto();
		System.out.println("------ Metodo de Pago ------");
		System.out.println("1 - Pago efectivo");
		System.out.println("2 - Pago con tarjeta");
		System.out.println("Elija el método de pago: ");
		optPago = scanner.nextInt();
		scanner.nextLine();
		
		switch(optPago) {
			case 1: 
				pago = new PagoEfectivo(LocalDate.now(), monto);
				break;
			case 2: 
				pago = new PagoTarjeta("TAR3226", LocalDate.now(), monto);
				break;
			default: System.out.println("error");
				break;
		}
		if(pago != null) {
			pago.realizarPago(monto);
			System.out.println();
			pago.imprimirRecibo();
		}
		
	}
	
}
